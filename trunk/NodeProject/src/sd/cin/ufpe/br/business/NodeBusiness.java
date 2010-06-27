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

	private ChunkDAO persistence;
	
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
	public boolean addFile(Object file) {
		// TODO Auto-generated method stub
		
		//boolean zerarArquivos = delFile(key);
		return false;
	}

	@Override
	public boolean addNode(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delFile(Integer idFile) {
		// TODO Auto-generated method stub
		boolean contemChunks = false;
		int idChunk = 1;
		do
		{
			
			ChunkPK key = new ChunkPK();
			key.setFileID(idFile);
			key.setId(idChunk);
			
			contemChunks = deleteChunkByKey(key);
			idChunk++;
		}while (!listChunks().isEmpty());
		return contemChunks;
	}

	@Override
	public boolean deleteNode(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getFile(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listFiles() {
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
	public boolean deleteChunkByKey(ChunkPK key) {
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
	public Object getChunk(int id, int fileID) {
		// TODO Auto-generated method stub
		ChunkPK chave = new ChunkPK();
		chave.setId(id);
		chave.setFileID(fileID);
		
		return persistence.buscarPorChave(chave);
		
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
