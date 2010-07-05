package br.cin.ufpe.in1118.middleware.distribution.services.naming.information;

import java.util.List;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public interface NamingInformation {

	String SERVICE_NAME = "Naming Information Service";

	public List<String> getAllServicesNames() throws RemoteException;
	
	public List<ServiceInformation> getServiceInformation(String serviceName) throws RemoteException;
	
	public List<LogInformation> getLog(String serviceName) throws RemoteException;
	
}
