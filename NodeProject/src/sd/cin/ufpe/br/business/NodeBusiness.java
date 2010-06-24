package sd.cin.ufpe.br.business;

import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.List;

import sd.cin.ufpe.br.dao.ChunkDAO;
import sd.cin.ufpe.br.dao.GenericDAO;
import sd.cin.ufpe.br.node.Chunk;
import sd.cin.ufpe.br.node.ChunkPK;
import sd.cin.ufpe.br.node.Node;

public class NodeBusiness implements IControlFile{

	private GenericDAO<Chunk> persistence;
	
	private static NodeBusiness instance = null;
	
	public static NodeBusiness getInstance()
    {
        if (instance == null)
        {
        	instance = new NodeBusiness();
        }
        return instance;
    }
	
	public NodeBusiness()
    {
		persistence = ChunkDAO.getInstance();
    }
	
	@Override
	public boolean addFile(ObjectInput file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNode(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delFile(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNode(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObjectInput getFile(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> listFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addChunk(Chunk chunk) {
		// TODO Auto-generated method stub
		boolean retorno = false;
		try{
			if(chunk != null)
			{
				persistence.begin();
				persistence.salvar(chunk);
				persistence.commit();
				retorno = true;
			}
		}catch(Exception e){
			persistence.rollback();
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public boolean deleteChunkByKey(Integer key) {
		// TODO Auto-generated method stub
		boolean retorno = false;
		
		try{
			persistence.begin();
			persistence.removerPorChave(key);
			persistence.commit();
			retorno = true;
		}
		catch(Exception e){
			persistence.rollback();
			e.printStackTrace();
		}
		return retorno;
	}

	
	@Override
	public Object getChunk(ChunkPK key) {
		// TODO Auto-generated method stub
		return persistence.buscarPorChave(key);
		
	}

	@Override
	public List<Chunk> listChunks() {
		// TODO Auto-generated method stub
		return persistence.buscarTodos();
	}

	@Override
	public boolean deleteChunk(Chunk chunk) {
		// TODO Auto-generated method stub
		boolean retorno = false;
		
		try{
			persistence.begin();
			persistence.remover(chunk);
			persistence.commit();
			retorno = true;
		}
		catch(Exception e){
			persistence.rollback();
			e.printStackTrace();
		}
		return retorno;
	}

}
