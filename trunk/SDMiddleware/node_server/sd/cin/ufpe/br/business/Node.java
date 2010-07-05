package sd.cin.ufpe.br.business;

public interface Node {

	public boolean inserir(Object object);

	public boolean remover(Object object);

	public Object merge(Object object);

	public Object buscarPorChave(Object object);
	
}
