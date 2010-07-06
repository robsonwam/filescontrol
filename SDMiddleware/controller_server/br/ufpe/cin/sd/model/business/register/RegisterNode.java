package br.ufpe.cin.sd.model.business.register;

import java.util.List;

import org.hibernate.criterion.Order;

import br.ufpe.cin.sd.model.business.entities.Node;
import br.ufpe.cin.sd.model.business.entities.NodePK;
import br.ufpe.cin.sd.model.persistence.dao.impl.NodeDAO;
import br.ufpe.cin.sd.model.persistence.interfaces.IRegister;

public class RegisterNode {
	private static RegisterNode registerNode = null;

    private IRegister<Node> iRegister = null;

    public static RegisterNode getInstance()
    {
        if (registerNode == null)
        {
            registerNode = new RegisterNode();
        }
        return registerNode;
    }
    
    private RegisterNode()
    {
        iRegister = NodeDAO.getInstance();
    }
    
    public boolean inserir(Object object){
    	boolean retorno = true;
		try {
			iRegister.begin();
			iRegister.salvar((Node) object);
			
		} catch (Exception e) {
			retorno = false;
			iRegister.rollback();
			e.printStackTrace();
		} finally {
			iRegister.commit();
			
		}
		return retorno;
    }

	public boolean remover(Node object) {
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

	public Object merge(Node object) {
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

	public Object buscarPorChave(NodePK nodePK) {
		return iRegister.buscarPorChave(nodePK);
	}

	@SuppressWarnings("unchecked")
	public List buscarPorExemplo(Node object, Order[] ordenacoes) {
		return iRegister.buscarPorExemplo(object, ordenacoes);
	}
	
	public Node buscarNodeMaisRequisitado() {
		return ((NodeDAO) iRegister).buscarNodeMaisRequisitado();
	}
}
