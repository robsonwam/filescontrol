package br.ufpe.cin.sd.model.persistence.dao.impl;

import br.ufpe.cin.sd.model.business.entities.Chunk;
import br.ufpe.cin.sd.model.persistence.dao.GenericDAO;

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
