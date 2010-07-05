package br.ufpe.cin.sd.controller;

import br.cin.ufpe.in1118.middleware.distribution.services.naming.Naming;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.NamingService;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;


public class ControllerClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Controller controller = null;
		Naming naming = NamingService.getNamingInstance("localhost", 9001);
		try {
			Object obj = naming.lookup("controllerService");
			if (obj instanceof Controller) {
				controller = (Controller) obj;
			}
			
//			controller.registerNode("192.168.0.1",8080);
			controller.ativarNode("192.168.0.1",8080, true);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
