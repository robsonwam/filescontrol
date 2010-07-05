package br.cin.ufpe.in1118.middleware.distribution.services.naming.information;

import java.util.List;

import br.cin.ufpe.in1118.middleware.distribution.services.GenericStub;
import br.cin.ufpe.in1118.middleware.distribution.services.ObjectReference;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

@SuppressWarnings("unchecked")
public class NamingInformation_Stub extends GenericStub implements NamingInformation {

	public NamingInformation_Stub(ObjectReference objectReference) {
		super(objectReference);
	}

	@Override
	public List<String> getAllServicesNames() {
		try {
			return (List<String>) super.execute("getAllServicesNames");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LogInformation> getLog(String serviceName) {
		try {
			return (List<LogInformation>) super.execute("getLog", serviceName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ServiceInformation> getServiceInformation(String serviceName) {
		try {
			return (List<ServiceInformation>) super.execute("getServiceInformation", serviceName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
