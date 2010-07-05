package br.cin.ufpe.in1118.middleware.distribution.message;


public class HTTPMessage extends Message {

	private static final long serialVersionUID = 1L;
	
	private String body;
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
}
