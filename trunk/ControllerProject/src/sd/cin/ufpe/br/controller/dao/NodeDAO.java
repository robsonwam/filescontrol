package sd.cin.ufpe.br.controller.dao;

import sd.cin.ufpe.br.controller.Node;

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
}
