package br.ufpe.cin.sd.model.business.register;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Order;

import br.ufpe.cin.sd.model.business.entities.Chunk;
import br.ufpe.cin.sd.model.business.entities.FileSd;
import br.ufpe.cin.sd.model.business.entities.Node;
import br.ufpe.cin.sd.model.persistence.dao.impl.ChunkDAO;
import br.ufpe.cin.sd.model.persistence.dao.impl.FileSdDAO;
import br.ufpe.cin.sd.model.persistence.dao.impl.NodeDAO;
import br.ufpe.cin.sd.model.persistence.interfaces.IRegister;

public class RegisterFileSd {
	private static RegisterFileSd registerFileSd = null;

    private IRegister<FileSd> iRegister = null;
    private IRegister<Node> iRegisterNode = null;
    private RegisterChunk iRegisterChunk = null;

    public static RegisterFileSd getInstance()
    {
        if (registerFileSd == null)
        {
            registerFileSd = new RegisterFileSd();
        }
        return registerFileSd;
    }
    
    private RegisterFileSd()
    {
        iRegister = FileSdDAO.getInstance();
        iRegisterNode = NodeDAO.getInstance();
        iRegisterChunk = RegisterChunk.getInstance();
    }
    
    public boolean inserir(FileSd fileSd){
    	boolean retorno = true;
		try {
			iRegister.begin();

			iRegister.salvar((FileSd) fileSd);
			
			ArrayList<Chunk> chunkList = this.chunkonizer(fileSd);
			iRegisterChunk.inserirListaBalanceada(chunkList);
			
		} catch (Exception e) {
			retorno = false;
			iRegister.rollback();
			e.printStackTrace();
		} finally {
			iRegister.commit();
			
		}
		return retorno;
    }

	public boolean remover(FileSd object) {
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

	public Object merge(FileSd object) {
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

	public Object buscarPorChave(Integer integer) {
		return iRegister.buscarPorChave(integer);
	}

	@SuppressWarnings("unchecked")
	public List buscarPorExemplo(FileSd object, Order[] ordenacoes) {
		return iRegister.buscarPorExemplo(object, ordenacoes);
	}
	
	// Method that break the file in chunks
	public ArrayList<Chunk> chunkonizer(FileSd fileSd) {
		byte[] fileArray = fileSd.getFile();
		ArrayList<Chunk> chunkList = new ArrayList<Chunk>();
		Node node = new Node();
		node.setAtivo(true);
		List<Node> nodeList = iRegisterNode.buscarPorExemplo(node, Order.asc("requisicoes"));
		int index = 0;
		int chunkLength = fileArray.length / nodeList.size();
		int rest = fileArray.length % nodeList.size();
		byte[] arrayChunk;

		for (int i = 0; i < nodeList.size(); i++) {
			if (i == nodeList.size()-1) {
				arrayChunk = new byte[chunkLength + rest];
				System.arraycopy(fileArray, index, arrayChunk, 0, chunkLength
						+ rest);
			} else {
				arrayChunk = new byte[chunkLength];
				System.arraycopy(fileArray, index, arrayChunk, 0, chunkLength);
				index = index + chunkLength;
			}
			Chunk chunk = new Chunk();
			chunk.setStream(arrayChunk);
			chunk.setFileSd(fileSd);
			chunkList.add(chunk);
		}

		// Ou envia o chunk logo aqui ou cria uma lista de chunks para ser usada
		// em [4]
		return chunkList;
	}
}
