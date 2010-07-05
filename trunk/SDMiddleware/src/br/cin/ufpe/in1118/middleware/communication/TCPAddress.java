package br.cin.ufpe.in1118.middleware.communication;

public class TCPAddress extends Address<TCPTransport> {

	private String host;
	private int port;
	private boolean server;
	
	public TCPAddress(String host, int port) {
		super();
		this.host = host;
		this.port = port;
		this.server = false;
	}
	
	public TCPAddress(int port) {
		this("localhost", port);
		this.server = true;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public TCPTransport getTransportNewTransportIntance() {
		return new TCPTransport(this.host, this.port, this.server);
	}
}
