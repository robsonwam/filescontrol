package br.cin.ufpe.in1118.middleware.distribution.services.naming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import br.cin.ufpe.in1118.middleware.distribution.services.JavaReference;
import br.cin.ufpe.in1118.middleware.distribution.services.ObjectReference;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.information.LogInformation;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.information.NamingInformation;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.information.ServiceInformation;
import br.cin.ufpe.in1118.middleware.distribution.services.util.MiddlewareUtil;
import br.cin.ufpe.in1118.middleware.distribution.services.util.Ping;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class Naming_Impl implements Naming, NamingInformation {

	private Map<String, List<ObjectReference>> objects;
	private Map<ObjectReference, Integer> serverStatus;
	private Map<String, List<LogInformation>> serviceLog;

	public Naming_Impl() {
		this.objects = new Hashtable<String, List<ObjectReference>>();
		this.serverStatus = new Hashtable<ObjectReference, Integer>();
		this.serviceLog = new Hashtable<String, List<LogInformation>>();
		this.loadThread();
	}

	private void loadThread() {
		new Thread("Naming Server Pinging Thread"){
			@Override
			public void run() {
				while(true){
					Collection<List<ObjectReference>> values = objects.values();
					List<ObjectReference> listao = new ArrayList<ObjectReference>();

					for (List<ObjectReference> list : values) {
						listao.addAll(list);
					}

					synchronized(Naming_Impl.this) {

						serverStatus.clear();
						for (ObjectReference objectReference : listao) {
							int ping = -1;
							if (MiddlewareUtil.isON(objectReference)) {							
								String host = objectReference.getHost();
								ping = Ping.ping(host);
							}
							serverStatus.put(objectReference, ping);
						}

					}

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) { }
				}
			}

			
		}.start();
	}
	
	@Override
	public synchronized void  bind(String serviceName, ObjectReference reference) throws RemoteException {
		List<ObjectReference> listObj = getListObjInstances(serviceName);
		List<LogInformation> listLog = getListLogInstances(serviceName);

		String message = String.format("Adicionando %s como provedor de %s", reference.toString(), serviceName);

		if (!listObj.contains(reference)) {
			listObj.add(reference);
		}
		listLog.add(new LogInformation(message));

		System.out.println(message);
	}

	private List<ObjectReference> getListObjInstances(String serviceName) {
		List<ObjectReference> listObj = this.objects.get(serviceName);
		if (listObj == null) {
			listObj = new ArrayList<ObjectReference>();
			this.objects.put(serviceName, listObj);
		}
		return listObj;
	}

	private List<LogInformation> getListLogInstances(String serviceName) {
		List<LogInformation> listLog = this.serviceLog.get(serviceName);
		if (listLog == null) {
			listLog = new ArrayList<LogInformation>();
			this.serviceLog.put(serviceName, listLog);
		}
		return listLog;
	}

	@Override
	public synchronized Object lookup(String serviceName) throws RemoteException {
		List<ObjectReference> list = this.objects.get(serviceName);

		if (list == null || list.isEmpty()) {
			throw new RemoteException("Nao existe nenhum servico dispon�vel com esse nome.");
		}

		List<LogInformation> listLog = getListLogInstances(serviceName);


		Collections.sort(list, new Comparator<ObjectReference>(){
			@Override
			public int compare(ObjectReference o1, ObjectReference o2) {
				int index1 = serverStatus.get(o1);
				int index2 = serverStatus.get(o2);

				index1 = index1>0?index1:Integer.MAX_VALUE;
				index2 = index2>0?index2:Integer.MAX_VALUE;

				return index1 - index2;
			}
		});


		Object reference = list.get(0);

		int ping = serverStatus.get(reference);

		listLog.add(new LogInformation("Lookup no servi�o " + serviceName + ", " + reference + ", ping=" + ping));
		
		if (ping < 0 && reference instanceof JavaReference) {
			throw new RemoteException("Nao existe nenhum servico dispon�vel com esse nome.");
		}

		return reference;
	}

	@Override
	public synchronized List<ServiceInformation> getServiceInformation(String serviceName) {
		List<ServiceInformation> result = new ArrayList<ServiceInformation>();

		for (ObjectReference objectReference : this.objects.get(serviceName)) {
			ServiceInformation si = new ServiceInformation(serviceName, objectReference, this.serverStatus.get(objectReference));
			result.add(si);
		}

		return result;
	}

	@Override
	public List<LogInformation> getLog(String serviceName) {
		return this.serviceLog.get(serviceName);
	}

	@Override
	public List<String> getAllServicesNames() {
		return new ArrayList<String>(this.objects.keySet());
	}

	@Override
	public void unbind(String serviceName) throws RemoteException {
		List<ObjectReference> list = this.objects.remove(serviceName);

		if (list == null || list.isEmpty()) {
			throw new RemoteException("Nao existe nenhum objeto com esse nome.");
		}

		List<LogInformation> listLog = getListLogInstances(serviceName);

		LogInformation logInf = new LogInformation("Unbind do servi�o " + serviceName);
		listLog.add(logInf);
	}

}
