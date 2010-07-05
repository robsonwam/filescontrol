package sd.cin.ufpe.br.business;

import br.cin.ufpe.in1118.middleware.distribution.services.naming.Naming;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.NamingService;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;
import sd.cin.ufpe.br.entities.ChunkNode;

public class NodeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node node = null;
		Naming naming = NamingService.getNamingInstance("localhost", 9001);
		try {
			Object obj = naming.lookup("nodeService");
			if (obj instanceof Node) {
				node = (Node) obj;
			}
			ChunkNode chunk = new ChunkNode();
			chunk.setId(1);
			chunk = (ChunkNode) node.buscarPorChave(chunk);
			System.out.println(chunk.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
