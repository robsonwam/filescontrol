package sd.cin.ufpe.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.CacheMode;

import org.hibernate.criterion.Order;

import sd.cin.ufpe.br.node.Chunk;



@SuppressWarnings("unchecked")


public abstract class GenericDAO<T> {
	
	
	private EntityManager em;
	private Class classePersistente;

	/** * Contrutor que guarda o tipo atual da classe T. */
	protected GenericDAO(Class classePersistente) {
		this.classePersistente = classePersistente;
		this.em = EntityManagerFactoryCreate.getInstance().getEm();
	}
	/*
	 * Digamos que você tenha recuperado sua lista de cidades como: 
	 * List<Cidade> cidades = query.list();  
	 * e que a classe Cidade tenha o campo "nome". Para ordenar você mesmo (sem depender do banco de dados) as cidades recebidas, você pode usar: 
	 *  List<Cidade> cidadesOrdenadas = new ArrayList<Cidade>(cidades);  
	 * final Collator ordenarIgnorandoAcentos = Collator.getInstance (new Locale ("pt", "BR"));  
	 * ordenarIgnorandoAcentos.setStrength (Collator.PRIMARY);  
	 * Collections.sort (cidadesOrdenadas, new Comparator<Cidade>() {  
	 *     public int compare (Cidade c1, Cidade c2) {  
	 *         return ordenarIgnorandoAcentos.compare (c1.getNome(), c2.getNome());  
	 *     }  
	 * });  
	 * 
	 * */
	public final void begin() {
		em.getTransaction().begin();
	}

	public final void commit() {
		em.getTransaction().commit();
	}
	
	public final void rollback() {
		em.getTransaction().rollback();
	}
	
	public final void close() {
		em.close();
	}

	/**
	 * * Atualiza o objeto que se encontra em memória. * * @param object *
	 * objeto a ser atualizado
	 */
	public final void refresh(T object) {
		getEntityManager().refresh(object);
	}

	/** * Executa o flush no entity manager. * */
	public final void flush() {
		getEntityManager().flush();
	}

	/** * Executa o flush no entity manager. * */
	public final void clear() {
		flush();
		getEntityManager().clear();
	}

	/**
	 * * Executa o merge do objeto que se encontra em memória. * * @param objeto
	 * * a ser realizado o merge * @return objeto que foi executado o merge
	 */
	public final T merge(T objeto) {
		objeto = getEntityManager().merge(objeto);
		return objeto;
	}

	/** * Salva o objeto atual na base de dados. * * @param objeto * a ser salvo */
	public final boolean salvar(T objeto) {
			getEntityManager().persist(objeto);
			return true;
	}

	/** * Remove o objeto da base de dados. * * @param objeto * a ser removido */
	public final boolean remover(T objeto) {
		Object obj = getEntityManager().merge(objeto);
		getEntityManager().remove(obj);
		return true;
	}

	/**
	 * * Remove o objeto uma vez passado sua chave como parâmetro. * * @param
	 * chave * identificadora do objeto
	 */
	public final boolean removerPorChave(Object chave) {
		Query query = getEntityManager().createQuery(
				"delete from " + getClassePersistente().getSimpleName()
				+ " c where c.id =" + chave);
		query.setHint("org.hibernate.cacheMode", CacheMode.REFRESH);
		query.executeUpdate();
		
		return true;
	}

	/**
	 * * Busca o objeto uma vez passado sua chave como parâmetro. * * @param
	 * chave * identificador * @return Objeto do tipo T
	 */
	public T buscarPorChave(Object chave) {
		
		T instance = null;
		try {
			instance = (T) getEntityManager().find(getClassePersistente(),
					chave);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return instance;
		
		
	}

	
		

	/**
	 * * Busca todos os objetos para aquela entidade específica. * * @param
	 * ordenacoes * lista de ordenações para pesquisa * @return lista de todos
	 * os objetos da entidade
	 */
	public List buscarTodos(Order... ordenacoes) {
		List results = null;
		try {
			Query query = getEntityManager().createQuery(
					"from " + getClassePersistente().getName()
					+ adicionaOrderByHql(ordenacoes));
			query.setHint("org.hibernate.cacheMode", CacheMode.REFRESH);
			results = query.getResultList();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return results;
	}

	/**
	 * * * Busca todos os objetos de uma entidade específica de um índice
	 * inicial * até um índice final. * * @param indiceInicial * indice inicial
	 * da busca * @param indiceFinal * indice final da pesquisa. * @param
	 * ordenacoes * lista de ordenação a ser criado * @return uma lista de
	 * objetos do tipo T
	 */
	public List buscarTodos(Integer indiceInicial, Integer indiceFinal,
			Order... ordenacoes) {
		List results = null;
		try {
			Query query = getEntityManager().createQuery(
					"from " + getClassePersistente().getName()
					+ adicionaOrderByHql(ordenacoes));
			query.setFirstResult(indiceInicial);
			query.setMaxResults(indiceFinal);
			results = (List) query.getResultList();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return results;
	}
	
	/**
	 * * * Busca todos os objetos de uma entidade específica de um índice
	 * inicial * até um índice final.@return uma lista de
	 * objetos do tipo T
	 */
	public List<T> buscarTodos() {
		List<T> results = null;
		try {
			Query query = getEntityManager().createQuery(
					"select t from " + getClassePersistente().getSimpleName() +" t");
			results = (List) query.getResultList();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return results;
	}

	/**
	 * * Utilizado para se injetar o Entity manager no DAO. * * @param
	 * entityManager * entity manager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	/**
	 * * Utilizado para se utilizar o entity manager nos DAOS que herdam do DAO
	 * * genérico. * * @return Entity manager.
	 */
	protected EntityManager getEntityManager() {
		return em;
	}

	/**
	 * * Adiciona o orderBy no final da query a ser utilizada. * * @param
	 * ordenacoes * a serem utilizadas para a busca * @return string com o
	 * orderBy
	 */
	protected final static String adicionaOrderByHql(Order... ordenacoes) {
		String result = "";
		if (ordenacoes.length > 0) {
			StringBuilder builder = new StringBuilder(" order by ");
			for (int i = 0; i < ordenacoes.length - 1; i++) {
				builder.append(ordenacoes[i].toString());
				builder.append(", ");
			}
			builder.append(ordenacoes[ordenacoes.length - 1]);
			result = builder.toString();
		}
		return result;
	}

	/**
	 * * Busca a classe persistente do objeto utilizado na classe. * * @return
	 * classe persistente
	 */
	protected final Class getClassePersistente() {
		return classePersistente;
	}
	public void addChunk(Chunk chunk) {
		// TODO Auto-generated method stub
		
	}

	
}