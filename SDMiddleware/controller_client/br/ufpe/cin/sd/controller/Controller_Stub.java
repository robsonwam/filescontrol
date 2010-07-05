package br.ufpe.cin.sd.controller;

import br.cin.ufpe.in1118.middleware.distribution.services.GenericStub;
import br.cin.ufpe.in1118.middleware.distribution.services.ObjectReference;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class Controller_Stub extends GenericStub implements Controller {

	public Controller_Stub(ObjectReference objectReference) {
		super(objectReference);
	}

	@Override
	public boolean registerNode(String ip, Integer port) {
		// TODO Auto-generated method stub
		try {
			return (Boolean) super.execute("registerNode", ip, port);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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

	@Override
	public void ativarNode(String host, Integer ip, Boolean ativo) {
		// TODO Auto-generated method stub
		try {
			super.execute("ativarNode", host, ip, ativo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}