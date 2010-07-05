package br.ufpe.cin.sd.controller;

import br.ufpe.cin.sd.model.business.entities.FileSd;


public class Controller_Skel implements Controller {
	
	private Controller controller = null;
	
	public Controller_Skel(){
		this.controller = new Controller_Impl();
	}

	@Override
	public boolean registerNode(String ip, Integer port){
		// TODO Auto-generated method stub
		return this.controller.registerNode(ip, port);
	}

	@Override
	public boolean inserir(Object object){
		// TODO Auto-generated method stub
		return this.controller.inserir(object);
	}

	@Override
	public boolean remover(Object object) {
		// TODO Auto-generated method stub
		return this.controller.remover(object);
	}

	@Override
	public Object merge(Object object){
		// TODO Auto-generated method stub
		return this.controller.merge(object);
	}

	@Override
	public Object buscarPorChave(Object object){
		// TODO Auto-generated method stub
		return this.controller.buscarPorChave(object);
	}

	@Override
	public void ativarNode(String host, Integer ip, Boolean ativo) {
		// TODO Auto-generated method stub
		this.controller.ativarNode(host, ip, ativo);
		
	}

	@Override
	public FileSd requestFile(int fileID) {
		// TODO Auto-generated method stub
		return this.controller.requestFile(fileID);
	}

}
