package br.cin.ufpe.in1118.middleware.distribution.services.naming;

import br.cin.ufpe.in1118.middleware.communication.TCPAddress;
import br.cin.ufpe.in1118.middleware.distribution.Middleware;
import br.cin.ufpe.in1118.middleware.distribution.services.JavaReference;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.information.NamingInformation;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class NamingServer {
	
	public static void main(String[] args) throws RemoteException {
		if (args.length != 1) {
			args = new String[] {"9001"};
		}
		
		int port = Integer.parseInt(args[0]);
		
		if (port <= 1 || port > 65535) {
			throw new IllegalArgumentException("As portas devem ser entre 0 e 65535!!");
		}
		
		System.out.println("==> Inicializando o servi�o de nomes");
		Middleware orbNamingServer = new Middleware(new TCPAddress(port));
		Naming_Skel skeleton = new Naming_Skel();
		orbNamingServer.addService("namingService", skeleton);
		orbNamingServer.addService("namingInformationService", skeleton);
		
		skeleton.bind(NamingInformation.SERVICE_NAME, new JavaReference(port, "namingInformationService", NamingInformation.class.getCanonicalName()));
		
		orbNamingServer.run();
	}

}
