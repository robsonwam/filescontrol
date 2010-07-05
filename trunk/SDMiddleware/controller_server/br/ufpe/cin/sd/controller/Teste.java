package br.ufpe.cin.sd.controller;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;
import sd.cin.ufpe.br.business.*;
import sd.cin.ufpe.br.entities.*;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Node node = NodeClient.getRemoteNode("172.20.10.32", 9501);
			ChunkNode chunkNode = new ChunkNode();
			byte[] bytes = {};
			chunkNode.setStream(bytes);
			chunkNode.setId(1);
			chunkNode.setFileId(1);
			node.inserir(chunkNode);
			System.out.println(chunkNode.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
