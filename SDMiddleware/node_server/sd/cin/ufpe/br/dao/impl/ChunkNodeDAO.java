package sd.cin.ufpe.br.dao.impl;

import sd.cin.ufpe.br.dao.GenericDAO;
import sd.cin.ufpe.br.entities.ChunkNode;

@SuppressWarnings("unchecked")
public class ChunkNodeDAO extends GenericDAO<ChunkNode> {

	private static ChunkNodeDAO chunkDAO = null;
	
	public static ChunkNodeDAO getInstance()
	{
		if (chunkDAO == null)
		{
			chunkDAO = new ChunkNodeDAO();
		}
		return chunkDAO;
	}
	
	
	protected ChunkNodeDAO() {
		super(ChunkNode.class);
	}

}
