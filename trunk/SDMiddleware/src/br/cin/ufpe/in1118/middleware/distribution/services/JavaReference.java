package br.cin.ufpe.in1118.middleware.distribution.services;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class JavaReference extends ObjectReference {

	private static final long serialVersionUID = 1L;

	private String host;
	private int port;
	private Object objectId;

	public JavaReference(String host, int port, Object objectId, String interfaceName) {
		super(interfaceName);
		this.host = host;
		this.port = port;
		this.objectId = objectId;
	}

	public JavaReference(int port, Object objectId, String interfaceName) {
		this(null, port, objectId, interfaceName);
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		this.setHost(hostAddress);
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Object getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Object objectId) {
		this.objectId = objectId;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ret = false;

		if (obj instanceof JavaReference) {
			JavaReference reference = (JavaReference) obj;

			if(reference.host.equalsIgnoreCase(this.host) &&
					reference.port == this.port &&
					reference.objectId.equals(this.objectId) &&
					reference.getInterfaceName().equalsIgnoreCase(this.getInterfaceName())){

				ret = true;

			}

		}

		return ret;
	}
	
	@Override
	public String toString() {
		return String.format("JavaReference[host=\"%s\", port='%05d']", host, port);
	}

}
