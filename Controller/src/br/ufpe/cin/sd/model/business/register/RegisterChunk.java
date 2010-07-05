package br.ufpe.cin.sd.model.business.register;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.NodeSetData;

import org.hibernate.criterion.Order;
import org.w3c.dom.NodeList;

import br.ufpe.cin.sd.exceptions.ExclusaoInvalidaException;
import br.ufpe.cin.sd.model.business.entities.Chunk;
import br.ufpe.cin.sd.model.business.entities.Node;
import br.ufpe.cin.sd.model.business.entities.NodePK;
import br.ufpe.cin.sd.model.persistence.dao.impl.ChunkDAO;
import br.ufpe.cin.sd.model.persistence.dao.impl.NodeDAO;
import br.ufpe.cin.sd.model.persistence.interfaces.IRegister;

public class RegisterChunk {
	private static RegisterChunk registerChunk = null;

    private IRegister<Chunk> iRegister = null;
    private IRegister<Node> iRegisterNode = null;

    public static RegisterChunk getInstance()
    {
        if (registerChunk == null)
        {
            registerChunk = new RegisterChunk();
        }
        return registerChunk;
    }
    
    private RegisterChunk()
    {
        iRegister = ChunkDAO.getInstance();
        iRegisterNode = NodeDAO.getInstance();
    }
    
    public boolean inserir(Object object){
    	boolean retorno = true;
		try {
			iRegister.begin();
			iRegister.salvar((Chunk) object);
		} catch (Exception e) {
			retorno = false;
			iRegister.rollback();
			e.printStackTrace();
		} finally {
			iRegister.commit();
			
		}
		return retorno;
    }
    
    public void inserirListaBalanceada(ArrayList<Chunk> chunkList){
    	Node node = new Node();
		node.setAtivo(true);
		ArrayList<Node> nodeList = (ArrayList<Node>) iRegisterNode.buscarPorExemplo(node, Order.asc("id"));
		for (int i = 0; i < nodeList.size(); i++) {
			for (int j = 0; j < chunkList.size()-1; j++) {
				String ip = nodeList.get(i).getId().getIp();
				int port = nodeList.get(i).getId().getPort();
				Chunk chunk = chunkList.get((j+i)%3);
				sendChunkToNode(chunk, ip, port);
			}
			try {
				iRegister.salvar(chunkList.get(i));
			} catch (ExclusaoInvalidaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
    private boolean sendChunkToNode(Chunk chunk, String ip, int port){
    	boolean result = false;
    	//Aqui vai o código de comunicacao
    	return result;
    }

	public boolean remover(Chunk object) {
		boolean retorno = true;
		
		try{
			iRegister.begin();
			iRegister.remover(object);
		}catch (Exception e) {
			retorno = false;
			iRegister.rollback();
			e.printStackTrace();
		} finally {
			iRegister.commit();
		}
		
		return retorno;
	}

	public Object merge(Chunk object) {
		Object retorno = null;
		iRegister.begin();
		retorno = iRegister.merge(object);
		iRegister.commit();
		return retorno;
	}
	
	public Object buscarPorChave(Integer id) {
		return iRegister.buscarPorChave(id);
	}

	@SuppressWarnings("unchecked")
	public List buscarPorExemplo(Chunk object, Order[] ordenacoes) {
		return iRegister.buscarPorExemplo(object, ordenacoes);
	}
}
