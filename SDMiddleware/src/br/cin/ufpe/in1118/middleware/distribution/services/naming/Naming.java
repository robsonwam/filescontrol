package br.cin.ufpe.in1118.middleware.distribution.services.naming;

import br.cin.ufpe.in1118.middleware.distribution.services.ObjectReference;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public interface Naming {
	
	void bind(String serviceName, ObjectReference reference) throws RemoteException;
	
	Object lookup(String serviceName) throws RemoteException;
	
	void unbind(String serviceName) throws RemoteException;
	
}
