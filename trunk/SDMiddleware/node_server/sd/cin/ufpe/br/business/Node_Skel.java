package sd.cin.ufpe.br.business;


public class Node_Skel implements Node {
	
	private Node node = null;
	
	public Node_Skel(){
		this.node = new Node_Impl();
	}

	@Override
	public boolean inserir(Object object){
		// TODO Auto-generated method stub
		return this.node.inserir(object);
	}

	@Override
	public boolean remover(Object object) {
		// TODO Auto-generated method stub
		return this.node.remover(object);
	}

	@Override
	public Object merge(Object object){
		// TODO Auto-generated method stub
		return this.node.merge(object);
	}

	@Override
	public Object buscarPorChave(Object object){
		// TODO Auto-generated method stub
		return this.node.buscarPorChave(object);
	}

	@Override
	public boolean inserirChunk(Integer idFile, Integer idChunk, byte[] stream) {
		// TODO Auto-generated method stub
		return this.node.inserirChunk(idFile, idChunk, stream);
	}

}
