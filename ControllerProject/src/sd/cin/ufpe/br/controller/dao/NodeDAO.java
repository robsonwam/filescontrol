package sd.cin.ufpe.br.controller.dao;

import javax.persistence.Query;

import org.hibernate.CacheMode;

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
		Query query = getEntityManager().createQuery(
				"delete from " + getClassePersistente().getSimpleName()
				+ " c where c.ip =" + ip + " and c.port =" + port.intValue());
		query.setHint("org.hibernate.cacheMode", CacheMode.REFRESH);
		query.executeUpdate();
		
		return true;
	}
}
