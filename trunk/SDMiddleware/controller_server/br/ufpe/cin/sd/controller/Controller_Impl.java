package br.ufpe.cin.sd.controller;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.criterion.Order;

import br.cin.ufpe.in1118.middleware.distribution.services.util.Ping;
import br.ufpe.cin.sd.exceptions.OperacaoInvalidaException;
import br.ufpe.cin.sd.model.business.entities.Arquivo;
import br.ufpe.cin.sd.model.business.entities.Chunk;
import br.ufpe.cin.sd.model.business.entities.FileSd;
import br.ufpe.cin.sd.model.business.entities.Node;
import br.ufpe.cin.sd.model.business.entities.NodePK;
import br.ufpe.cin.sd.model.business.register.RegisterChunk;
import br.ufpe.cin.sd.model.business.register.RegisterFileSd;
import br.ufpe.cin.sd.model.business.register.RegisterNode;

public class Controller_Impl implements Controller {

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
	public boolean registerNode(String ip, Integer port) {
		boolean result = false;
		NodePK pk = new NodePK();
		pk.setIp(ip);
		pk.setPort(port);
		Node node = new Node();
		node.setId(pk);
		Node nodeOld = (Node) this.buscarPorChave(node);
		if(nodeOld != null){
			nodeOld.setAtivo(true);
			this.merge(nodeOld);
			result = true;
		}else{
			node.setRequisicoes(0);
			node.setAtivo(true);
			result = this.inserir(node);
		}
		
		return result;
	}

	public boolean inserir(Object object) {
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
		}
		return false;
	}

	public boolean remover(Object object) {
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
		}
		return false;

	}

	public Object merge(Object object) {

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
		}
		return object;

	}

	public Object buscarPorChave(Object object) {
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
		}
		return object;
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

		FileSd fileTrans = (FileSd) buscarPorChave(fileSd);
		result.setId(fileTrans.getId());
		result.setName(fileTrans.getName());
		reqFileArray = new byte[fileTrans.getSize()];
		ArrayList<Chunk> chunkList = (ArrayList<Chunk>) fileTrans.getChunks();
		for (Chunk chunk : chunkList) {
			reqChunkList.add(requestChunk(chunk));
		}

		int index = 0;
		for (int i = 0; i < reqChunkList.size(); i++) {
			System.arraycopy(reqChunkList.get(i).getStream(), 0, reqFileArray,
					index, reqChunkList.get(i).getStream().length);
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
				// result = metodo que traz o pedaco
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

	public Controller_Impl() {
		super();
		registerChunk = RegisterChunk.getInstance();
		registerFileSd = RegisterFileSd.getInstance();
		registerNode = RegisterNode.getInstance();
		loadThread();
	}

	@Override
	public void ativarNode(String host, Integer ip, Boolean ativo) {
		NodePK pk = new NodePK();
		pk.setPort(ip);
		pk.setIp(host);
		Node node = new Node();
		node.setId(pk);
		node = (Node) this.buscarPorChave(node);
		node.setAtivo(ativo);
		merge(node);

	}

	private void loadThread() {
		new Thread("Server Pinging Thread") {
			@Override
			public void run() {
				while (true) {
					Node node = new Node();
					node.setRequisicoes(0);
					Order[] orders = { Order.asc("id") };

					List<Node> listao = null;
					try {
						listao = buscaPorExemplo(node, orders);
					} catch (OperacaoInvalidaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					synchronized (Controller_Impl.this) {
						boolean ativo = false;

						for (Node no : listao) {
							int ping = -1;
							if (isON(no)) {
								String host = no.getId().getIp();
								ping = Ping.ping(host);
							}
							// changeServerStatus(no, ping);
							if (ping == 1) {
								ativo = true;
							}
							ativarNode(no.getId().getIp(),
									no.getId().getPort(), ativo);
						}

					}

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
				}
			}

		}.start();
	}

	public static boolean isON(Node node) {
		String host = node.getId().getIp();
		int port = -1;
		port = node.getId().getPort();

		try {
			Socket s = new Socket(host, port);
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
