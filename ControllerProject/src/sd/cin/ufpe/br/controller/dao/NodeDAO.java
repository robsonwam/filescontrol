package sd.cin.ufpe.br.controller.dao;

import javax.persistence.Query;

import org.hibernate.CacheMode;
import org.hibernate.criterion.Order;

import sd.cin.ufpe.br.controller.Node;
import sd.cin.ufpe.br.controller.NodePK;

public class NodeDAO extends GenericDAO<Node>{
	
	private static NodeDAO nodeDAO = null;
	
	protected NodeDAO() {
		super(Node.class);
		// TODO Auto-generated constructor stub
	}
	
	public static NodeDAO getInstance()
	{
		if (nodeDAO == null)
		{
			nodeDAO = new NodeDAO();
		}
		return nodeDAO;
	}
	
	/**
	 * * Remove o objeto uma vez passado sua chave como parâmetro. * * @param
	 * chave * identificadora do objeto
	 */
	public final boolean removerPorChave(String ip, Integer port) {
		Node node = new Node();
		NodePK pk = new NodePK();
		pk.setIp(ip);
		pk.setPort(port);
		node = this.buscarPorChave(pk);
		
		this.remover(node);
		
		return true;
	}
}
