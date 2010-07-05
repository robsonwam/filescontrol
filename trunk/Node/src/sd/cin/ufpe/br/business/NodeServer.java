package sd.cin.ufpe.br.business;

import br.cin.ufpe.in1118.middleware.communication.TCPAddress;
import br.cin.ufpe.in1118.middleware.distribution.Middleware;
import br.cin.ufpe.in1118.middleware.distribution.services.JavaReference;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.Naming;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.NamingService;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;


public class NodeServer {

	public static void main(String[] args) throws RemoteException {
		
		if (args.length != 3) {
			args = new String[] {"localhost", "9001", "9500"};
		}
		
		String hostNamingServer = args[0];
		int portNamingServer = Integer.parseInt(args[1]);
		int port = Integer.parseInt(args[2]);
		
		if (portNamingServer <= 1 || portNamingServer > 65535 || port <= 1 || port > 65535) {
			throw new IllegalArgumentException("As portas devem ser entre 0 e 65535!!");
		}
		
		System.out.println("===> Inicializando o serviço Node");
		Middleware orbIBDCIn = new Middleware(new TCPAddress(port));
		orbIBDCIn.addService("nService", new Node_Skel());
		orbIBDCIn.run();
		
		System.out.println("===> Incluindo uma referência do Node no serviço de Nomes");
		Naming naming = NamingService.getNamingInstance(hostNamingServer, portNamingServer);
		naming.bind("nodeService", new JavaReference(port, "nService", Node.class.getCanonicalName()));
	}
}
