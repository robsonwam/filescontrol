package sd.cin.ufpe.br.controller;

public class Node_old {
	
	private String ip;
	private String port;
	
	public Node_old(String ip, String port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
