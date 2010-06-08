package sd.cin.ufpe.br.node;


import java.io.ByteArrayInputStream;
import java.io.ObjectInput;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;


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
		
	
		
	public boolean delChunk(int id) {
		// TODO Auto-generated method stub
		return false;
	}

		
	public Object getChunk(int id) {
		EntityTransaction transaction = getEntityManager().getTransaction();

		Object chunk = null;
					
		try {

			transaction.begin();
			
			System.out.println("chunk começou busca");
			//Query query1 = getEntityManager().createQuery("SELECT c FROM Chunk c WHERE c.idChunk = :param");
			System.out.println("chunk começou busca xxx");   
			//   query1.setParameter("param", id);
			  

			chunk = (Object) getEntityManager().find(Chunk.class,id);   
			
			
						
		} catch (Exception e) {
			transaction.rollback();

			System.err.println("Erro: " + e.getMessage());
		} finally {
			getEntityManager().close();
		}
		
		return chunk;
	}
}
