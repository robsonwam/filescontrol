package sd.cin.ufpe.br.business;

import sd.cin.ufpe.br.register.RegisterChunk;
import sd.cin.ufpe.br.entities.ChunkNode;


public class Node_Impl implements Node{

	private RegisterChunk registerChunk = null;


//	private static Controller instance = null;
//
//	public static Controller getInstance() {
//		if (instance == null) {
//			instance = new Controller();
//		}
//		return instance;
//	}
//	
	
	

	public boolean inserir(Object object) {
		if (object instanceof ChunkNode) {
			return registerChunk.inserir((ChunkNode) object);
		}
		return false;
	}

	public boolean remover(Object object) {
		if (object instanceof ChunkNode) {
			return registerChunk.remover((ChunkNode) object);
		}
		return false; 

	}

	public Object merge(Object object) {

		if (object instanceof ChunkNode) {
			return registerChunk.merge((ChunkNode) object);
		}
		return object;
	}

	public Object buscarPorChave(Object object) {
		if (object instanceof ChunkNode) {
			return registerChunk.buscarPorChave(((ChunkNode) object).getId());
		}
		return object;
	}


	public Node_Impl() {
		super();
		registerChunk = RegisterChunk.getInstance();
	}

}
