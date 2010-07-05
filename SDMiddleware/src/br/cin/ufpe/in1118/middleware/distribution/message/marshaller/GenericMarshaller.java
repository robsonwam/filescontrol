package br.cin.ufpe.in1118.middleware.distribution.message.marshaller;

import java.io.Serializable;
import java.util.Hashtable;

import br.cin.ufpe.in1118.middleware.distribution.exceptions.MarshallException;
import br.cin.ufpe.in1118.middleware.distribution.message.HTTPMessage;
import br.cin.ufpe.in1118.middleware.distribution.message.JavaMessage;

public class GenericMarshaller implements Marshaller<Serializable> {

	private Hashtable<Class<?>, Marshaller<?>> marshalers;
	
	private static GenericMarshaller instance;
	
	private GenericMarshaller() {
		this.marshalers = new Hashtable<Class<?>, Marshaller<?>>();
		this.carregarMarshallers();
	}

	public static GenericMarshaller getInstance(){
		if(instance == null){
			instance = new GenericMarshaller();
		}
		
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public byte[] marshall(Serializable obj) throws MarshallException {
		byte[] ret = null;
		
		Marshaller specificMarshaller = this.marshalers.get(obj.getClass());
		if(specificMarshaller != null){
			ret = specificMarshaller.marshall(obj);
		}else{
			throw new MarshallException("no specific marshaller found");
		}
		
		return ret;
	}

	private void carregarMarshallers(){
		this.marshalers.put(JavaMessage.class, JavaMessageMarshaller.getInstance());
		this.marshalers.put(HTTPMessage.class, HTTPMessageMarshaller.getInstance());
	}
	
}
