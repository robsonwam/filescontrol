package br.ufpe.cin.sd.model.persistence.dao.impl;

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
	
	
	protected NodeDAO() {
		super(Node.class);
	}

}
