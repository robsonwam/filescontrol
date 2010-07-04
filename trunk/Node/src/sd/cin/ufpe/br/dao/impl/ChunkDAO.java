package sd.cin.ufpe.br.dao.impl;

import sd.cin.ufpe.br.dao.GenericDAO;
import sd.cin.ufpe.br.entities.Chunk;

@SuppressWarnings("unchecked")
public class ChunkDAO extends GenericDAO<Chunk> {

	private static ChunkDAO chunkDAO = null;
	
	public static ChunkDAO getInstance()
	{
		if (chunkDAO == null)
		{
			chunkDAO = new ChunkDAO();
		}
		return chunkDAO;
	}
	
	
	protected ChunkDAO() {
		super(Chunk.class);
	}

}
