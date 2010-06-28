package sd.cin.ufpe.br.dao;


import java.io.ByteArrayInputStream;
import java.io.ObjectInput;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.CacheMode;

import sd.cin.ufpe.br.node.Chunk;
import sd.cin.ufpe.br.node.ChunkPK;


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
	
	/**
	 * * Remove o objeto uma vez passado sua chave como parâmetro. * * @param
	 * chave * identificadora do objeto
	 */
	public Object selecionarPorChave(Integer chave,Integer chave2) {
		
		Query query = getEntityManager().createQuery(
				"select c from " + getClassePersistente().getSimpleName()
				+ " c where c.id.id =" + chave.intValue() +" and c.id.fileID="
				+chave2.intValue());
		System.out.println("consulta ="+ query.toString());
		query.setHint("org.hibernate.cacheMode", CacheMode.REFRESH);
		Object result = query.getSingleResult();
		
		return result;
	}
	
	/**
	 * * Remove o objeto uma vez passado sua chave como parâmetro. * * @param
	 * chave * identificadora do objeto
	 */
	public final boolean deleteChunksByFile(Integer fileID) {
		Query query = getEntityManager().createQuery(
				"delete from " + getClassePersistente().getSimpleName()
				+ " c where c.id.fileID="
				+fileID);
			
		query.setHint("org.hibernate.cacheMode", CacheMode.REFRESH);
		query.executeUpdate();
		
		return true;
	}
}
