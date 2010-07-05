package br.cin.ufpe.in1118.middleware.distribution.message.marshaller;

import br.cin.ufpe.in1118.middleware.distribution.exceptions.MarshallException;
import br.cin.ufpe.in1118.middleware.distribution.message.HTTPMessage;


class HTTPMessageMarshaller implements Marshaller<HTTPMessage> {

	private static HTTPMessageMarshaller instance;
	
	private HTTPMessageMarshaller() {
		
	}

	public static HTTPMessageMarshaller getInstance(){
		if(instance == null){
			instance = new HTTPMessageMarshaller();
		}
		
		return instance;
	}
	
	public byte[] marshall(HTTPMessage message) throws MarshallException {
		try {
			byte[] bytes = message.getBody().getBytes();
			return bytes;
			
		} catch (Exception e) {
			throw new MarshallException("Erro ao serializar", e);
		}
	}
}
