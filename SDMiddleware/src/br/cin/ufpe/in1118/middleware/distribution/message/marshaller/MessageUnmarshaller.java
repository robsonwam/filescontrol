package br.cin.ufpe.in1118.middleware.distribution.message.marshaller;

import br.cin.ufpe.in1118.middleware.distribution.message.Message;

public class MessageUnmarshaller extends Unmarshaller<Message> {
	
	private static MessageUnmarshaller instance;
	
	private MessageUnmarshaller() {}
	
	public static MessageUnmarshaller getInstance(){
		if (instance == null) {
			instance = new MessageUnmarshaller();
		}
		
		return instance;
	}
}
