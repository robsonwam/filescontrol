package br.ufpe.cin.sd.controller;

import java.util.List;

import org.hibernate.criterion.Order;

import br.ufpe.cin.sd.exceptions.ExclusaoInvalidaException;
import br.ufpe.cin.sd.exceptions.OperacaoInvalidaException;

public class Facade {

	public Facade() {
		// TODO Auto-generated constructor stub
	}

	private Controller getController() {
		return Controller.getInstance();
	}


	public boolean inserir(Object object) throws OperacaoInvalidaException{
		return this.getController().inserir(object);
	}

	public boolean remover(Object object) throws OperacaoInvalidaException, ExclusaoInvalidaException
	{
		return this.getController().remover(object);
	}

	public Object atualizar(Object objeto) throws OperacaoInvalidaException {
		return this.getController().merge(objeto);
	}

	public Object buscarPorChave(Object chave) throws OperacaoInvalidaException {
		return this.getController().buscarPorChave(chave);
	}

	@SuppressWarnings("unchecked")
	public List buscaPorExemplo(Object objeto, String atributo) throws OperacaoInvalidaException{
		
		Order[] ordenacoes = {Order.asc(atributo)};
		
		return this.getController().buscaPorExemplo(objeto, ordenacoes);
	}
}
