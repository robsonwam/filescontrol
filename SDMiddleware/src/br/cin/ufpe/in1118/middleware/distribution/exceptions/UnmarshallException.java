package br.cin.ufpe.in1118.middleware.distribution.exceptions;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class UnmarshallException extends RemoteException {

	private static final long serialVersionUID = 1L;

	public UnmarshallException() {
	}

	public UnmarshallException(String message) {
		super(message);
	}

	public UnmarshallException(Throwable cause) {
		super(cause);
	}

	public UnmarshallException(String message, Throwable cause) {
		super(message, cause);
	}

}
