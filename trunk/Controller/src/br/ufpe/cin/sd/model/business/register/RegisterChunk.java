package br.ufpe.cin.sd.model.business.register;

import java.util.List;

import org.hibernate.criterion.Order;

import br.ufpe.cin.sd.model.business.entities.Chunk;
import br.ufpe.cin.sd.model.business.entities.ChunkPK;
import br.ufpe.cin.sd.model.persistence.dao.impl.ChunkDAO;
import br.ufpe.cin.sd.model.persistence.interfaces.IRegister;

public class RegisterChunk {
	private static RegisterChunk registerChunk = null;

    private IRegister<Chunk> iRegister = null;

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

	public Object buscarPorChave(ChunkPK chunkPK) {
		return iRegister.buscarPorChave(chunkPK);
	}

	@SuppressWarnings("unchecked")
	public List buscarPorExemplo(Chunk object, Order[] ordenacoes) {
		return iRegister.buscarPorExemplo(object, ordenacoes);
	}
}
