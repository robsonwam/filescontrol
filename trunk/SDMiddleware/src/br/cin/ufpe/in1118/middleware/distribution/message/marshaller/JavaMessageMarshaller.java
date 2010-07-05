package br.cin.ufpe.in1118.middleware.distribution.message.marshaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import br.cin.ufpe.in1118.middleware.distribution.exceptions.MarshallException;
import br.cin.ufpe.in1118.middleware.distribution.message.Message;


class JavaMessageMarshaller implements Marshaller<Message> {

	private static JavaMessageMarshaller instance;
	
	private JavaMessageMarshaller() {
		
	}

	public static JavaMessageMarshaller getInstance(){
		if(instance == null){
			instance = new JavaMessageMarshaller();
		}
		
		return instance;
	}
	
	public byte[] marshall(Message message) throws MarshallException {
		try {
			ByteArrayOutputStream bytesStream = new ByteArrayOutputStream();
			ObjectOutputStream objectStream = new ObjectOutputStream(bytesStream);
			
			objectStream.writeObject(message);
			objectStream.flush();
			
			byte[] bytes = bytesStream.toByteArray();
			
			objectStream.close();
			bytesStream.close();
			
			return bytes;
			
		} catch (IOException e) {
			throw new MarshallException("Erro ao serializar", e);
		}
	}
}
