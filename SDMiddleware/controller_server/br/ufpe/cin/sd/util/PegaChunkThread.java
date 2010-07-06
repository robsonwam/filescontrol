package br.ufpe.cin.sd.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import sd.cin.ufpe.br.business.NodeClient;
import sd.cin.ufpe.br.entities.ChunkNode;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;
import br.ufpe.cin.sd.controller.Controller;
import br.ufpe.cin.sd.model.business.entities.Chunk;
import br.ufpe.cin.sd.model.business.entities.Node;

public class PegaChunkThread extends Thread {
	
	ArrayList<Chunk> reqChunkList = null;
	Chunk chunk = null;
	Controller controller = null;
	
	public PegaChunkThread(ArrayList<Chunk> reqChunkList, Chunk chunk, Controller controller) {
		// TODO Auto-generated constructor stub
		this.reqChunkList = reqChunkList;
		this.chunk = chunk;
		this.controller = controller;
	}
	
	public void start(){
		super.start();
	}
	
	public void run(){
		try {
			reqChunkList.add(this.requestChunk(chunk));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				synchronized (PegaChunkThread.this) {
					chunkNode = (ChunkNode) remoteNode.buscarPorChave(chunkNode);
				
					node.setRequisicoes(node.getRequisicoes()+1);
					this.controller.merge(node);
				}
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

}
