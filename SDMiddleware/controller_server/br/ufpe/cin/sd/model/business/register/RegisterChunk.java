package br.ufpe.cin.sd.model.business.register;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.xml.crypto.NodeSetData;

import org.hibernate.criterion.Order;
import org.w3c.dom.NodeList;

import sd.cin.ufpe.br.business.NodeClient;
import sd.cin.ufpe.br.entities.ChunkNode;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;
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
    private IRegister<Node> iRegisterNodeDao = null;
    private RegisterNode registerNode = null;

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
        iRegisterNodeDao = NodeDAO.getInstance();
        registerNode = RegisterNode.getInstance();
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
    
    public void inserirListaBalanceada(ArrayList<Chunk> chunkList) throws RemoteException, ExclusaoInvalidaException{
    	Node node = new Node();
		node.setAtivo(true);
		ArrayList<Node> nodeList = (ArrayList<Node>) iRegisterNodeDao.buscarPorExemplo(node, Order.asc("id"));
		nodeList.addAll(nodeList);
		
		for(int i = 0; i< chunkList.size(); i++){//chunk
			Chunk chunk = chunkList.get(i);
			chunk.setNodes(new LinkedHashSet<Node>());
			for(int j = i; j<i+ chunkList.size() - 1; j++){//node
				node = nodeList.get(j);
				chunk.getNodes().add(node);
				if(node.getChunks() == null){
					node.setChunks(new LinkedHashSet<Chunk>());
				}
				node.getChunks().add(chunk);
				
			}
			iRegister.salvar(chunk);
			
			for (Node node2 : chunk.getNodes()) {
				sd.cin.ufpe.br.business.Node remoteNode = NodeClient.getRemoteNode(node2.getId().getIp(), node2.getId().getPort());
				
				ChunkNode chunkNode = new ChunkNode();
				chunkNode.setFileId(chunk.getFileSd().getId());
				chunkNode.setId(chunk.getId());
				chunkNode.setStream(chunk.getStream());
				remoteNode.inserir(chunkNode);
			}
		}
		
//		for (int i = 0; i < nodeList.size(); i++) {
//			Chunk chunk = null;
//			Set<Chunk> setChunk = new LinkedHashSet<Chunk>() ;
//			for (int j = 0; j < chunkList.size()-1; j++) {
//				chunk = chunkList.get((j+i)%chunkList.size());
//				iRegister.salvar(chunk);
//				setChunk.add(chunk);
//			}
//			Node nodeI = nodeList.get(i);
//			nodeI = iRegisterNodeDao.merge(nodeI);
//			nodeList.get(i).setChunks(nodeI.getChunks());
//			nodeI.setChunks(setChunk);
//			sd.cin.ufpe.br.business.Node remoteNode = NodeClient.getRemoteNode(nodeI.getId().getIp(), nodeI.getId().getPort());
//			for (Chunk chunk2 : setChunk) {
//				ChunkNode chunkNode = new ChunkNode();
//				chunkNode.setFileId(chunk2.getFileSd().getId());
//				chunkNode.setId(chunk2.getId());
//				chunkNode.setStream(chunk2.getStream());
//				remoteNode.inserir(chunkNode);
//			}
//		}
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
		try{
			iRegister.begin();
			retorno = iRegister.merge(object);
		}catch (Exception e) {
			retorno = false;
			iRegister.rollback();
			e.printStackTrace();
		} finally {
			iRegister.commit();
		}
		
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
