package sd.cin.ufpe.br.controller;
import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class NodePK implements Serializable {
	private String ip;

	private Integer port;

	private static final long serialVersionUID = 1L;

	public NodePK() {
		super();
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

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if ( ! (o instanceof NodePK)) {
			return false;
		}
		NodePK other = (NodePK) o;
		return this.ip.equals(other.ip)
			&& this.port.equals(other.port);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ip.hashCode();
		hash = hash * prime + this.port.hashCode();
		return hash;
	}

}
