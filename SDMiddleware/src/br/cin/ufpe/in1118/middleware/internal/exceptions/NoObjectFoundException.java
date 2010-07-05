package br.cin.ufpe.in1118.middleware.internal.exceptions;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class NoObjectFoundException extends RemoteException {

	private static final long serialVersionUID = 1L;

	public NoObjectFoundException(String message) {
		super("Nenhuma Conexao com o nome(" + message + ") foi encontrada");
	}

	public NoObjectFoundException(Throwable cause) {
		super(cause);
	}

	public NoObjectFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
