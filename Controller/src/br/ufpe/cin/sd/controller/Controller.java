package br.ufpe.cin.sd.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

	// private static Controller instance = null;
	//
	// public static Controller getInstance() {
	// if (instance == null) {
	// instance = new Controller();
	// }
	// return instance;
	// }
	//	
	public Controller() {
		super();
		registerChunk = RegisterChunk.getInstance();
		registerFileSd = RegisterFileSd.getInstance();
		registerNode = RegisterNode.getInstance();
	}

	public boolean registerNode(String ip, Integer port)
			throws OperacaoInvalidaException {
		NodePK pk = new NodePK();
		pk.setIp(ip);
		pk.setPort(port);
		Node node = new Node();
		node.setId(pk);
		node.setAtivo(true);
		node.setRequisicoes(0);
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
			fileSd.setSize(((Arquivo) object).getFile().length);
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

		} else {
			throw new OperacaoInvalidaException();
		}
	}

	public FileSd requestFile(int fileID) {
		FileSd result = null;

		FileSd fileSd = new FileSd();
		fileSd.setId(fileID);

		byte[] reqFileArray = null;
		ArrayList<Chunk> reqChunkList = null;

		try {
			FileSd fileTrans = (FileSd) buscarPorChave(fileSd);
			result.setId(fileTrans.getId());
			result.setName(fileTrans.getName());
			reqFileArray = new byte[fileTrans.getSize()];
			ArrayList<Chunk> chunkList = (ArrayList<Chunk>) fileTrans.getChunks();
			for (Chunk chunk : chunkList) {
				reqChunkList.add(requestChunk(chunk));
			}
		} catch (OperacaoInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int index = 0;
		for (int i = 0; i < reqChunkList.size(); i++) {
			System.arraycopy(reqChunkList.get(i).getStream(), 0,
					reqFileArray, index, reqChunkList.get(i).getStream().length);
			index = index + reqChunkList.get(i).getStream().length;
		}
		
		result.setFile(reqFileArray);
		
		return result;
	}

	private Chunk requestChunk(Chunk chunkTrans) {
		Chunk result = null;

		ArrayList<Node> nodeList = (ArrayList<Node>) chunkTrans.getNodes();

		Node reqNode = null;
		Collections.sort(nodeList, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.getRequisicoes() - o2.getRequisicoes();
			}
		});
		for (Node node : nodeList) {
			if (node.getAtivo() == true) {
				reqNode = node;
				//result = metodo que traz o pedaco
				if(result != null){
					break;
				}
			}
		}
		return result;
	}

}
