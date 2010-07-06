package br.ufpe.cin.sd.controller;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Order;

import sd.cin.ufpe.br.business.NodeClient;
import sd.cin.ufpe.br.entities.ChunkNode;

import br.cin.ufpe.in1118.middleware.distribution.services.util.Ping;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;
import br.ufpe.cin.sd.exceptions.OperacaoInvalidaException;
import br.ufpe.cin.sd.model.business.entities.Chunk;
import br.ufpe.cin.sd.model.business.entities.FileSd;
import br.ufpe.cin.sd.model.business.entities.Node;
import br.ufpe.cin.sd.model.business.entities.NodePK;
import br.ufpe.cin.sd.model.business.register.RegisterChunk;
import br.ufpe.cin.sd.model.business.register.RegisterFileSd;
import br.ufpe.cin.sd.model.business.register.RegisterNode;
import br.ufpe.cin.sd.util.PegaChunkThread;

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
			node.setChunks(new LinkedHashSet<Chunk>());
			
			result = this.inserir(node);
			
			Node mostRequired = null;
			mostRequired = registerNode.buscarNodeMaisRequisitado();
			
//			if(mostRequired != null){
//				node.setChunks(mostRequired.getChunks());
//			}
			for (Chunk chunk : mostRequired.getChunks()) {
				chunk.getNodes().add(node);
				node.getChunks().add(chunk);
				this.merge(chunk);
				
			}
			this.merge(node);
			sd.cin.ufpe.br.business.Node nodeOrigem = null;
			sd.cin.ufpe.br.business.Node nodeDestino = null;
		    try {
				nodeDestino = NodeClient.getRemoteNode(node.getId().getIp(), node.getId().getPort());
				nodeOrigem = NodeClient.getRemoteNode(mostRequired.getId().getIp(), mostRequired.getId().getPort());
				for (Chunk chunk : mostRequired.getChunks()) {
					ChunkNode chunkNode = new ChunkNode();
					chunkNode.setId(chunk.getId());
					nodeDestino.inserir(nodeOrigem.buscarPorChave(chunkNode));
				}
		    } catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	public boolean inserir(Object object) {
		if (object instanceof Chunk) {
			return registerChunk.inserir((Chunk) object);
		} else if (object instanceof FileSd) {
			FileSd fileSd = new FileSd();
			fileSd.setFile(((FileSd) object).getFile());
			fileSd.setId(((FileSd) object).getId());
			fileSd.setName(((FileSd) object).getName());
			fileSd.setSize(((FileSd) object).getFile().length);
			return registerFileSd.inserir(fileSd);
		} else if (object instanceof Node) {
			return registerNode.inserir((Node) object);
		}
		return false;
	}

	public boolean remover(Object object) {
		if (object instanceof Chunk) {
			return registerChunk.remover((Chunk) object);
		} else if (object instanceof FileSd) {
			FileSd fileSd = new FileSd();
			fileSd.setFile(((FileSd) object).getFile());
			fileSd.setId(((FileSd) object).getId());
			fileSd.setName(((FileSd) object).getName());
			return registerFileSd.remover(fileSd);
		} else if (object instanceof Node) {
			return registerNode.remover((Node) object);
		}
		return false;

	}

	public Object merge(Object object) {

		if (object instanceof Chunk) {
			return registerChunk.merge((Chunk) object);
		} else if (object instanceof FileSd) {
			FileSd fileSd = new FileSd();
			fileSd.setFile(((FileSd) object).getFile());
			fileSd.setId(((FileSd) object).getId());
			fileSd.setName(((FileSd) object).getName());
			return registerFileSd.merge(fileSd);
		} else if (object instanceof Node) {
			return registerNode.merge((Node) object);
		}
		return object;

	}

	public Object buscarPorChave(Object object) {
		if (object instanceof Chunk) {
			return registerChunk.buscarPorChave(((Chunk) object).getId());
		} else if (object instanceof FileSd) {
			FileSd fileSd = new FileSd();
			fileSd.setFile(((FileSd) object).getFile());
			fileSd.setId(((FileSd) object).getId());
			fileSd.setName(((FileSd) object).getName());
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

		} else if (object instanceof FileSd) {
			FileSd fileSd = new FileSd();
			fileSd.setFile(((FileSd) object).getFile());
			fileSd.setId(((FileSd) object).getId());
			fileSd.setName(((FileSd) object).getName());
			return registerFileSd.buscarPorExemplo(fileSd, ordenacoes);

		} else if (object instanceof Node) {
			return registerNode.buscarPorExemplo((Node) object, ordenacoes);

		} else {
			throw new OperacaoInvalidaException();
		}
	}

	public FileSd requestFile(Integer fileID) {
		FileSd result = new FileSd();

		FileSd fileSd = new FileSd();
		fileSd.setId(fileID);

		byte[] reqFileArray = null;
		ArrayList<Chunk> reqChunkList = new ArrayList<Chunk>();

		FileSd fileTrans = (FileSd) buscarPorChave(fileSd);
		result.setId(fileTrans.getId());
		result.setName(fileTrans.getName());
		reqFileArray = new byte[fileTrans.getSize()];
		Set<Chunk> chunkList = fileTrans.getChunks();
		for (Chunk chunk : chunkList) {
			PegaChunkThread pegaChunk = new PegaChunkThread(reqChunkList, chunk, this);
			
			pegaChunk.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//				try {
//					reqChunkList.add(requestChunk(chunk));
//				} catch (RemoteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		}
		while(chunkList.size() > reqChunkList.size()){
			//Aguardando pegar todos os chunks
		}
		
		Collections.sort(reqChunkList, new Comparator<Chunk>() {

			@Override
			public int compare(Chunk o1, Chunk o2) {
				return o1.getId() - o2.getId();
			}
		});

		int index = 0;
		for (int i = 0; i < reqChunkList.size(); i++) {
			System.arraycopy(reqChunkList.get(i).getStream(), 0, reqFileArray,
					index, reqChunkList.get(i).getStream().length);
			index = index + reqChunkList.get(i).getStream().length;
		}

		result.setFile(reqFileArray);

		return result;
	}

	private Chunk requestChunk(Chunk chunkTrans) throws RemoteException {
		Chunk result = null;

		ArrayList<Node> nodeList = new ArrayList<Node>(chunkTrans.getNodes());

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
				sd.cin.ufpe.br.business.Node remoteNode = NodeClient.getRemoteNode(reqNode.getId().getIp(), reqNode.getId().getPort());
				ChunkNode chunkNode = new ChunkNode();
				chunkNode.setId(chunkTrans.getId());
				chunkNode = (ChunkNode) remoteNode.buscarPorChave(chunkNode);
				node.setRequisicoes(node.getRequisicoes()+1);
				this.merge(node);
				result = new Chunk();
				result.setId(chunkNode.getId());
				result.setStream(chunkNode.getStream());
				if (result.getStream() != null) {
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
							ativo = false;
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
