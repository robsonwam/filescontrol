package sd.cin.ufpe.br.business;

import br.cin.ufpe.in1118.middleware.distribution.services.GenericStub;
import br.cin.ufpe.in1118.middleware.distribution.services.ObjectReference;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class Node_Stub extends GenericStub implements Node {

	public Node_Stub(ObjectReference objectReference) {
		super(objectReference);
	}

	@Override
	public boolean inserir(Object object) {
		// TODO Auto-generated method stub
		try {
			return (Boolean) super.execute("inserir", object);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remover(Object object) {
		// TODO Auto-generated method stub
		try {
			return (Boolean) super.execute("remover", object);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object merge(Object object){
		// TODO Auto-generated method stub
		try {
			return super.execute("merge", object);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object buscarPorChave(Object object){
		// TODO Auto-generated method stub
		try {
			return super.execute("buscarPorChave", object);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
