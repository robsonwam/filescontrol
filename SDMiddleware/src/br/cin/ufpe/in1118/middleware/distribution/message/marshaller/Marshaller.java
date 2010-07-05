package br.cin.ufpe.in1118.middleware.distribution.message.marshaller;

import java.io.Serializable;

import br.cin.ufpe.in1118.middleware.distribution.exceptions.MarshallException;

public interface Marshaller <T extends Serializable> {
	byte[] marshall(T i) throws MarshallException;
}
