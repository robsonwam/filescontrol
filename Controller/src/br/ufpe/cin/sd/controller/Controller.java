package br.ufpe.cin.sd.controller;

import java.util.List;

import org.hibernate.criterion.Order;

import br.ufpe.cin.sd.exceptions.ExclusaoInvalidaException;
import br.ufpe.cin.sd.exceptions.OperacaoInvalidaException;
import br.ufpe.cin.sd.model.business.entities.Arquivo;
import br.ufpe.cin.sd.model.business.entities.Chunk;
import br.ufpe.cin.sd.model.business.entities.FileSd;
import br.ufpe.cin.sd.model.business.entities.Node;
import br.ufpe.cin.sd.model.business.entities.NodePK;
import br.ufpe.cin.sd.model.business.register.RegisterChunk;
import br.ufpe.cin.sd.model.business.register.RegisterFileSd;
import br.ufpe.cin.sd.model.business.register.RegisterNode;

public class Controller {

	private RegisterChunk registerChunk = null;
	private RegisterFileSd registerFileSd = null;
	private RegisterNode registerNode = null;

//	private static Controller instance = null;
//
//	public static Controller getInstance() {
//		if (instance == null) {
//			instance = new Controller();
//		}
//		return instance;
//	}
//	
	public boolean registerNode(String ip, Integer port) throws OperacaoInvalidaException{
		NodePK pk = new NodePK();
		pk.setIp(ip);
		pk.setPort(port);
		Node node = new Node();
		node.setId(pk);
		node.setEstado(true);
		//node.setNumRequisicoes(0);
		return this.inserir(node);
	}
	

	public boolean inserir(Object object) throws OperacaoInvalidaException {
		if (object instanceof Chunk) {
			return registerChunk.inserir((Chunk) object);
		} else if (object instanceof Arquivo) {
			FileSd fileSd = new FileSd();
			fileSd.setFile(((Arquivo) object).getFile());
			fileSd.setId(((Arquivo) object).getId());
			fileSd.setName(((Arquivo) object).getName());
			return registerFileSd.inserir(fileSd);
		} else if (object instanceof Node) {
			return registerNode.inserir((Node) object);
		} else {
			throw new OperacaoInvalidaException();
		}
	}

	public boolean remover(Object object) throws OperacaoInvalidaException,
			ExclusaoInvalidaException {
		if (object instanceof Chunk) {
			return registerChunk.remover((Chunk) object);
		} else if (object instanceof Arquivo) {
			FileSd fileSd = new FileSd();
			fileSd.setFile(((Arquivo) object).getFile());
			fileSd.setId(((Arquivo) object).getId());
			fileSd.setName(((Arquivo) object).getName());
			return registerFileSd.remover(fileSd);
		} else if (object instanceof Node) {
			return registerNode.remover((Node) object);
		} else {
			throw new OperacaoInvalidaException();
		}

	}

	public Object merge(Object object) throws OperacaoInvalidaException {

		if (object instanceof Chunk) {
			return registerChunk.merge((Chunk) object);
		} else if (object instanceof Arquivo) {
			FileSd fileSd = new FileSd();
			fileSd.setFile(((Arquivo) object).getFile());
			fileSd.setId(((Arquivo) object).getId());
			fileSd.setName(((Arquivo) object).getName());
			return registerFileSd.merge(fileSd);
		} else if (object instanceof Node) {
			return registerNode.merge((Node) object);
		} else {
			throw new OperacaoInvalidaException();
		}

	}

	public Object buscarPorChave(Object object)
			throws OperacaoInvalidaException {
		if (object instanceof Chunk) {
			return registerChunk.buscarPorChave(((Chunk) object).getId());
		} else if (object instanceof Arquivo) {
			FileSd fileSd = new FileSd();
			fileSd.setFile(((Arquivo) object).getFile());
			fileSd.setId(((Arquivo) object).getId());
			fileSd.setName(((Arquivo) object).getName());
			return registerFileSd.buscarPorChave(fileSd.getId());
		} else if (object instanceof Node) {
			return registerNode.buscarPorChave(((Node) object).getId());
		} else {
			throw new OperacaoInvalidaException();
		}
	}

	@SuppressWarnings("unchecked")
	public List buscaPorExemplo(Object object, Order[] ordenacoes)
			throws OperacaoInvalidaException {
		if (object instanceof Chunk) {
			return registerChunk.buscarPorExemplo((Chunk) object, ordenacoes);

		} else if (object instanceof Arquivo) {
			FileSd fileSd = new FileSd();
			fileSd.setFile(((Arquivo) object).getFile());
			fileSd.setId(((Arquivo) object).getId());
			fileSd.setName(((Arquivo) object).getName());
			return registerFileSd.buscarPorExemplo(fileSd, ordenacoes);

		} else if (object instanceof Node) {
			return registerNode.buscarPorExemplo((Node) object, ordenacoes);

		}
		else {
			throw new OperacaoInvalidaException();
		}
	}


	public Controller() {
		super();
		registerChunk = RegisterChunk.getInstance();
		registerFileSd = RegisterFileSd.getInstance();
		registerNode = RegisterNode.getInstance();
	}

}
