package br.cin.ufpe.in1118.middleware.distribution.handlers;

import br.cin.ufpe.in1118.middleware.communication.Transport;

public class ClientRequestHandler extends RequestHandler {
	
	public ClientRequestHandler(Transport transport) {
		super(transport);
	}
	
	public void close() {
		getTransport().close();
	}
}
