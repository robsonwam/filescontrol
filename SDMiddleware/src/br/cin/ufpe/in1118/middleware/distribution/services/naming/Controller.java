package br.cin.ufpe.in1118.middleware.distribution.services.naming;

import java.util.List;

public interface Controller {

	public boolean registerNode(String ip, Integer port);

	public boolean inserir(Object object);

	public boolean remover(Object object);

	public Object merge(Object object);

	public Object buscarPorChave(Object object);

}
