package sd.cin.ufpe.br.node;

import java.io.ByteArrayInputStream;
import java.io.ObjectInput;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;


public class ChunkDAO implements INodeFile{

	private EntityManagerFactory factory = null;
	private EntityManager manager;
	
	public ChunkDAO() {
		// TODO Auto-generated constructor stub
		factory = Persistence.createEntityManagerFactory("FileControl");
		manager = factory.createEntityManager();
	}
	
	
	@Override
	public boolean addChunk(Chunk chunk) {
		// TODO Auto-generated method stub
		
		Boolean result;	
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			
			transaction.begin();

			manager.persist(chunk);

			transaction.commit();
			
			result = true;
					
		} catch (Exception e) {
			transaction.rollback();
			result = false;

		} finally {
			manager.close();
			
		}
		return result;
	}
	
	@Override
	public boolean delChunk(int id) {
		// TODO Auto-generated method stub
		return false;
	}

		
	public Object getChunk(int id) {
		EntityTransaction transaction = manager.getTransaction();

		Object chunk = null;
					
		try {

			transaction.begin();
			
			System.out.println("chunk começou busca");
			//Query query1 = getEntityManager().createQuery("SELECT c FROM Chunk c WHERE c.idChunk = :param");
			System.out.println("chunk começou busca xxx");   
			//   query1.setParameter("param", id);
			  

			chunk = (Object) manager.find(Chunk.class,id);   
			
			
						
		} catch (Exception e) {
			transaction.rollback();

			System.err.println("Erro: " + e.getMessage());
		} finally {
			manager.close();
		}
		
		return chunk;
	}
	
	protected EntityManager getEntityManager() {
		return manager;
	}
}
