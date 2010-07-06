package br.ufpe.cin.sd.model.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.ufpe.cin.sd.model.business.entities.Chunk;
import br.ufpe.cin.sd.model.business.entities.Node;
import br.ufpe.cin.sd.model.persistence.dao.GenericDAO;

@SuppressWarnings("unchecked")
public class NodeDAO extends GenericDAO<Node> {

	private static NodeDAO nodeDAO = null;
	
	public static NodeDAO getInstance()
	{
		if (nodeDAO == null)
		{
			nodeDAO = new NodeDAO();
		}
		return nodeDAO;
	}
	
	public Node buscarNodeMaisRequisitado() {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(Node.class);
		
		criteria.add(Restrictions.eq("ativo", true));
		
		criteria.addOrder((org.hibernate.criterion.Order) Order.desc("requisicoes"));
		
		if(criteria.list().size() > 0){
			return (Node) criteria.list().get(0);
		}
		else{
			return null;
		}

		
	}
	
	public List<Node> getNodesByChunk(Chunk chunk) {
		List<Node> lista = null;
		List<Node> result = new ArrayList<Node>();;
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(Node.class);
		
		criteria.add(Restrictions.eq("ativo", true));
		
		criteria.addOrder((org.hibernate.criterion.Order) Order.desc("requisicoes"));
		
		lista = criteria.list();
		
		for (Node node : lista) {
			Set<Chunk> listaChunks = node.getChunks();
			for (Chunk chunk2 : listaChunks) {
				if(chunk2.getId().equals(chunk.getId())){
					result.add(node);
					break;
				}
				
			}
		}
		return result;
	}
	
	
	protected NodeDAO() {
		super(Node.class);
	}

}
