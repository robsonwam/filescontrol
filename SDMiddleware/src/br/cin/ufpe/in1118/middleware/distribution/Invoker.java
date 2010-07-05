package br.cin.ufpe.in1118.middleware.distribution;

import java.io.EOFException;
import java.lang.reflect.Method;
import java.net.SocketException;
import java.util.ArrayList;

import br.cin.ufpe.in1118.middleware.communication.Transport;
import br.cin.ufpe.in1118.middleware.distribution.handlers.ServerRequestHandler;
import br.cin.ufpe.in1118.middleware.distribution.message.JavaMessage;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;
import br.cin.ufpe.in1118.middleware.internal.exceptions.NoObjectFoundException;

public class Invoker {

	private ServicePool servicePool;
	private ServerRequestHandler serverHandler;
	private Transport transport;

	public Invoker(Transport transport) {
		this.transport = transport;
		this.servicePool = new ServicePool();
	}

	public void addService(Object key, Object object) {
		this.servicePool.putIntoPool(key, object);
	}

	private Object getService(Object key) throws NoObjectFoundException {
		return this.servicePool.getFromPool(key);
	}

	protected void process(ServerRequestHandler serverRequestHandler) throws RemoteException {
		JavaMessage msg = null;
		Object ret = null;
		boolean withException = false;
		try {
			msg = (JavaMessage) serverRequestHandler.receive();
			Object remoteObject = this.getService(msg.getObjectId());
			ret = this.invoke(remoteObject, msg);
		} catch (Exception e) {
			e.printStackTrace();
			ret = e;
			withException = true;
		} finally {
			if (msg == null) return;
			msg.setReturn(ret);
			msg.setWithException(withException);
			serverRequestHandler.send(msg);
		}
	}

	private Object invoke(Object remoteObject, JavaMessage msg) throws Exception {
		Object ret = null;
		Class<?> serverClass = remoteObject.getClass();
		Method method = this.getMethodByMessage(serverClass, msg);

		ArrayList<Object> parameters = msg.getParameters();
		ret = method.invoke(remoteObject, (Object[]) parameters.toArray(new Object[parameters.size()]));

		return ret;
	}

	private Method getMethodByMessage(Class<?> objectClass, JavaMessage message) throws RemoteException {
		Method ret = null;

		try {
			String operation = message.getOperation();
			ArrayList<Object> parameters = message.getParameters();
			Class<?>[] parametersArray = new Class<?>[parameters.size()];

			int index = 0;
			for (Object obj : parameters) {
				parametersArray[index++] = obj.getClass();
			}

			Method[] methods = objectClass.getMethods();

			for (int i = 0; i < methods.length; i++) {
				Method m = methods[i];
				if (m.getName().equals(operation)
						&& compArrays(parametersArray, m.getParameterTypes())
						&& (ret == null
								|| ret.getReturnType().isAssignableFrom(m.getReturnType())))
					ret = m;
			}

			if (ret == null) {
				throw new RemoteException("metodo nao encontrado");
			}

		} catch (SecurityException e) {
			e.printStackTrace();
			throw new RemoteException(e);
		}

		return ret;
	}

	private boolean compArrays(Class<?>[] parametersArray,
			Class<?>[] parameterTypes) {


		if (parametersArray == null && parameterTypes == null) return true;
		if (parametersArray.length != parameterTypes.length) return false;

		boolean result = true;

		for (int i = 0; i < parameterTypes.length; i++) {
			Class<?> clazz1 = parameterTypes[i];
			Class<?> clazz2 = parametersArray[i];

			result &= clazz1.isAssignableFrom(clazz2);
		}

		return result;
	}

	public void init() {
		new Thread("Invoker Thread") {
			@Override
			public void run() {
				Invoker.this.serverHandler = new ServerRequestHandler(Invoker.this.transport);

				while (true) {
					try {
						Invoker.this.process(Invoker.this.serverHandler);
						Thread.sleep(100);
					} catch (Exception e) {
						Class<?> cl = e.getCause().getClass();
						if (cl.equals(EOFException.class) || cl.equals(SocketException.class)) {
							continue;
						}
						e.printStackTrace();
					}
				}

			}
		}.start();
	}
}
