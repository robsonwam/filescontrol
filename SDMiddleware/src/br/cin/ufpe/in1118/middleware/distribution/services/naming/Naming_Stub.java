package br.cin.ufpe.in1118.middleware.distribution.services.naming;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.cin.ufpe.in1118.middleware.distribution.services.GenericStub;
import br.cin.ufpe.in1118.middleware.distribution.services.ObjectReference;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class Naming_Stub extends GenericStub implements Naming {
	
	public Naming_Stub(ObjectReference ref) {
		super(ref);
	}

	@Override
	public void bind(String serviceName, ObjectReference reference) throws RemoteException {
		super.execute("bind", serviceName, reference);
	}

	@Override
	public Object lookup(String serviceName) throws RemoteException {
		ObjectReference objReference = (ObjectReference) super.execute("lookup", serviceName);
		String interfaceName = objReference.getInterfaceName();
		Constructor<?> constructor;

		try {
			Class<?> forName = Class.forName(interfaceName + "_Stub");

			constructor = forName.getConstructor(ObjectReference.class);
		} catch (SecurityException e1) {
			e1.printStackTrace();
			throw new RemoteException(e1);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw new RemoteException(e1);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new RemoteException(e);
		}

		try {
			return constructor.newInstance(objReference);
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new RemoteException(e);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new RemoteException(e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RemoteException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RemoteException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new RemoteException(e);
		}
	}

	@Override
	public void unbind(String serviceName) throws RemoteException {
		super.execute("unbind", serviceName);
	}

}
