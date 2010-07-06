package sd.cin.ufpe.br.business;

public interface Node {

	public boolean inserir(Object object);
	
	public boolean inserirChunk(Integer idFile, Integer idChunk, byte[] stream);

	public boolean remover(Object object);

	public Object merge(Object object);

	public Object buscarPorChave(Object object);
	
}
