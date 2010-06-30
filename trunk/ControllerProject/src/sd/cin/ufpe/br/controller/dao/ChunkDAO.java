package sd.cin.ufpe.br.controller.dao;

import sd.cin.ufpe.br.dao.ChunkDAO;

public class ChunkDAO extends GenericDAO<Chunk> {

	protected ChunkDAO(Class classePersistente) {
		super(classePersistente);
		// TODO Auto-generated constructor stub
	}
	
	private static ChunkDAO chunkDAO = null;
	
	public static ChunkDAO getInstance()
	{
		if (chunkDAO == null)
		{
			chunkDAO = new ChunkDAO();
		}
		return chunkDAO;
	}

}
