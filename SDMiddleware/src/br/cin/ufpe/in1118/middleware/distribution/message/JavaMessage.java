package br.cin.ufpe.in1118.middleware.distribution.message;

import java.util.ArrayList;

public class JavaMessage extends Message {

	private static final long serialVersionUID = 1L;
	
	private long messageId;
	private Object objectId;
	private String operation;
	private ArrayList<Object> parameters;
	private Object ret;
	private boolean withException;

	public JavaMessage(Object objectId, String operation, ArrayList<Object> parameters, Object ret) {
		super();
		this.objectId = objectId;
		this.operation = operation;
		this.parameters = parameters;
		this.ret = ret;
	}
	
	public long getMessageId() {
		return messageId;
	}
	
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public Object getObjectId() {
		return objectId;
	}

	public void setObjectId(Object objectId) {
		this.objectId = objectId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public ArrayList<Object> getParameters() {
		return parameters;
	}

	public void setParametros(ArrayList<Object> parameters) {
		this.parameters = parameters;
	}

	public Object getReturn() {
		return ret;
	}

	public void setReturn(Object ret) {
		this.ret = ret;
	}

	public void setWithException(boolean withException) {
		this.withException = withException;
	}

	public boolean hasException() {
		return withException;
	}

}
