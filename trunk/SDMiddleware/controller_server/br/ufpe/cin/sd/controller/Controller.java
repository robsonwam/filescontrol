package br.ufpe.cin.sd.controller;

import br.ufpe.cin.sd.model.business.entities.FileSd;

public interface Controller {

	public boolean registerNode(String ip, Integer port);

	public boolean inserir(Object object);

	public boolean remover(Object object);

	public Object merge(Object object);

	public Object buscarPorChave(Object object);
	
	public void ativarNode(String host, Integer ip, Boolean ativo);
	
	public FileSd requestFile(int fileID);

}
