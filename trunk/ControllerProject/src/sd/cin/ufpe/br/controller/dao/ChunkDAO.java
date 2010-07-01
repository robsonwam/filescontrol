package sd.cin.ufpe.br.controller.dao;


import sd.cin.ufpe.br.controller.Chunk;

public class ChunkDAO extends GenericDAO<Chunk> {

	protected ChunkDAO() {
		super(Chunk.class);
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



