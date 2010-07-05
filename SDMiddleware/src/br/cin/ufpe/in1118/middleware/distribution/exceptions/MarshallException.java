package br.cin.ufpe.in1118.middleware.distribution.exceptions;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class MarshallException extends RemoteException {

	private static final long serialVersionUID = 1L;

	public MarshallException() {
	}

	public MarshallException(String message) {
		super(message);
	}

	public MarshallException(Throwable cause) {
		super(cause);
	}

	public MarshallException(String message, Throwable cause) {
		super(message, cause);
	}

}
