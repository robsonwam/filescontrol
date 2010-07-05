package br.cin.ufpe.in1118.middleware.distribution.message;

public class SOAPFaultException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SOAPFaultException(String message) {
		super(message);
	}

}
