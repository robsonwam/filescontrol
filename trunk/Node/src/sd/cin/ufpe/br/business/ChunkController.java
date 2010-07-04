package sd.cin.ufpe.br.business;

import java.util.List;

import org.hibernate.criterion.Order;

import sd.cin.ufpe.br.exceptions.ExclusaoInvalidaException;
import sd.cin.ufpe.br.exceptions.OperacaoInvalidaException;
import sd.cin.ufpe.br.entities.Chunk;
import sd.cin.ufpe.br.register.RegisterChunk;


public class ChunkController {

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
	
	

	public boolean inserir(Object object) throws OperacaoInvalidaException {
		if (object instanceof Chunk) {
			return registerChunk.inserir((Chunk) object);
		}else {
			throw new OperacaoInvalidaException();
		}
	}

	public boolean remover(Object object) throws OperacaoInvalidaException,
			ExclusaoInvalidaException {
		if (object instanceof Chunk) {
			return registerChunk.remover((Chunk) object);
		} else {
			throw new OperacaoInvalidaException();
		}

	}

	public Object merge(Object object) throws OperacaoInvalidaException {

		if (object instanceof Chunk) {
			return registerChunk.merge((Chunk) object);
		} else {
			throw new OperacaoInvalidaException();
		}

	}

	public Object buscarPorChave(Object object)
			throws OperacaoInvalidaException {
		if (object instanceof Chunk) {
			return registerChunk.buscarPorChave(((Chunk) object).getId());
		} else {
			throw new OperacaoInvalidaException();
		}
	}

	@SuppressWarnings("unchecked")
	public List buscaPorExemplo(Object object, Order[] ordenacoes)
			throws OperacaoInvalidaException {
		if (object instanceof Chunk) {
			return registerChunk.buscarPorExemplo((Chunk) object, ordenacoes);

		} else {
			throw new OperacaoInvalidaException();
		}
	}


	public ChunkController() {
		super();
		registerChunk = RegisterChunk.getInstance();
	}

}
