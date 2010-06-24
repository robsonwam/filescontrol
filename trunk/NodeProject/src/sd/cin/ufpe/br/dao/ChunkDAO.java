package sd.cin.ufpe.br.dao;


import java.io.ByteArrayInputStream;
import java.io.ObjectInput;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sd.cin.ufpe.br.node.Chunk;


public class ChunkDAO extends GenericDAO<Chunk>{


	public ChunkDAO() {
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
