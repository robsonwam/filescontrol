package br.cin.ufpe.in1118.middleware.distribution.services.naming;

import java.util.List;

import br.cin.ufpe.in1118.middleware.distribution.services.ObjectReference;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.information.LogInformation;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.information.NamingInformation;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.information.ServiceInformation;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class Naming_Skel implements Naming, NamingInformation {
	
	private Naming_Impl impl;
	
	public Naming_Skel() {
		this.impl = new Naming_Impl();
	}

	@Override
	public void bind(String problemType, ObjectReference reference) throws RemoteException {
		this.impl.bind(problemType, reference);
	}

	@Override
	public Object lookup(String problemType) throws RemoteException {
		return this.impl.lookup(problemType);
	}

	@Override
	public void unbind(String serviceName) throws RemoteException {
		this.impl.unbind(serviceName);
	}

	@Override
	public List<String> getAllServicesNames() {
		return this.impl.getAllServicesNames();
	}

	@Override
	public List<LogInformation> getLog(String serviceName) {
		return this.impl.getLog(serviceName);
	}

	@Override
	public List<ServiceInformation> getServiceInformation(String serviceName) {
		return this.impl.getServiceInformation(serviceName);
	}
	
}
