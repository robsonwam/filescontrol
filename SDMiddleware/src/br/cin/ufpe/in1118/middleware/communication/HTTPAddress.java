package br.cin.ufpe.in1118.middleware.communication;


public class HTTPAddress extends Address<HTTPTransport> {

	private String uri = null;
	
	public HTTPAddress(String url) {
		super();
		this.setURL(url);
	}
	
	public String getURL() {
		return this.uri;
	}
	
	public void setURL(String url) {
		this.uri = url;
	}
	
	@Override
	public HTTPTransport getTransportNewTransportIntance() {
		return new HTTPTransport(this.uri);
	}
}
