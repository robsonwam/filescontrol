package br.cin.ufpe.in1118.middleware.distribution.message.marshaller;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import br.cin.ufpe.in1118.middleware.distribution.exceptions.UnmarshallException;
import br.cin.ufpe.in1118.middleware.distribution.message.HTTPMessage;

public abstract class Unmarshaller <T extends Serializable> {
	
	@SuppressWarnings("unchecked")
	public T unmarshal(byte[] bytes) throws UnmarshallException{
		try {
			T ret = null;
			
			ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
			ObjectInputStream objectStream = new ObjectInputStream(byteStream);
			
			ret = (T) objectStream.readObject();
			
			return ret;
		} catch (Exception e) {
			try {
				String body = new String(bytes);
				HTTPMessage http = new HTTPMessage();
				http.setBody(body);
				
				return (T) http;
			} catch (Exception e1) {
				throw new UnmarshallException(e);
			}
		} 
	}
}
