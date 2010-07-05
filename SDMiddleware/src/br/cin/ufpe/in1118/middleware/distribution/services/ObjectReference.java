package br.cin.ufpe.in1118.middleware.distribution.services;

import java.io.Serializable;

public abstract class ObjectReference implements Serializable {

	private static final long serialVersionUID = 1L;

	private String interfaceName;
	
	public ObjectReference(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public abstract String toString();
	
	public abstract String getHost();

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

}
