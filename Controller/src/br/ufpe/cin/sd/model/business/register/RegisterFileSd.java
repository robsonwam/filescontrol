package br.ufpe.cin.sd.model.business.register;

import java.util.List;

import org.hibernate.criterion.Order;

import br.ufpe.cin.sd.model.business.entities.FileSd;
import br.ufpe.cin.sd.model.persistence.dao.impl.FileSdDAO;
import br.ufpe.cin.sd.model.persistence.interfaces.IRegister;

public class RegisterFileSd {
	private static RegisterFileSd registerFileSd = null;

    private IRegister<FileSd> iRegister = null;

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
    }
    
    public boolean inserir(Object object){
    	boolean retorno = true;
		try {
			iRegister.begin();
			iRegister.salvar((FileSd) object);
			
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
		iRegister.begin();
		retorno = iRegister.merge(object);
		iRegister.commit();
		return retorno;
	}

	public Object buscarPorChave(Integer integer) {
		return iRegister.buscarPorChave(integer);
	}

	@SuppressWarnings("unchecked")
	public List buscarPorExemplo(FileSd object, Order[] ordenacoes) {
		return iRegister.buscarPorExemplo(object, ordenacoes);
	}
}
