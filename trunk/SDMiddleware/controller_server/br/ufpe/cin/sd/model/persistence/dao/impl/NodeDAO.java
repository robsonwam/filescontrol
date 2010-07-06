package br.ufpe.cin.sd.model.persistence.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
		
		criteria.addOrder((org.hibernate.criterion.Order) Order.asc("requisicoes"));
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Node) criteria.list().get(0);
	}	
	
	
	protected NodeDAO() {
		super(Node.class);
	}

}
