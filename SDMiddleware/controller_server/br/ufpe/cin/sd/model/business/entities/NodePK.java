package br.ufpe.cin.sd.model.business.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the node database table.
 * 
 */
@Embeddable
public class NodePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String ip;

	private Integer port;

    public NodePK() {
    }
	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getPort() {
		return this.port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NodePK)) {
			return false;
		}
		NodePK castOther = (NodePK)other;
		return 
			this.ip.equals(castOther.ip)
			&& this.port.equals(castOther.port);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ip.hashCode();
		hash = hash * prime + this.port.hashCode();
		
		return hash;
    }
}