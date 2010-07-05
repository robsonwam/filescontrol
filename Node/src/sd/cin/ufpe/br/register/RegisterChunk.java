package sd.cin.ufpe.br.register;

import java.util.List;

import org.hibernate.criterion.Order;

import sd.cin.ufpe.br.dao.impl.ChunkNodeDAO;
import sd.cin.ufpe.br.entities.ChunkNode;

public class RegisterChunk {
	private static RegisterChunk registerChunk = null;

    private IRegister<ChunkNode> iRegister = null;

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
        iRegister = ChunkNodeDAO.getInstance();
    }
    
    public boolean inserir(Object object){
    	boolean retorno = true;
		try {
			iRegister.begin();
			iRegister.salvar((ChunkNode) object);
			
		} catch (Exception e) {
			retorno = false;
			iRegister.rollback();
			e.printStackTrace();
		} finally {
			iRegister.commit();
			
		}
		return retorno;
    }

	public boolean remover(ChunkNode object) {
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

	public Object merge(ChunkNode object) {
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
	public List buscarPorExemplo(ChunkNode object, Order[] ordenacoes) {
		return iRegister.buscarPorExemplo(object, ordenacoes);
	}
}
