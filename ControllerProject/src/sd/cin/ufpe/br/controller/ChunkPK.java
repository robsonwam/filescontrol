package sd.cin.ufpe.br.controller;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChunkPK implements Serializable {
	@Column(name="fileID", insertable=false, updatable=false)
	private Integer fileid2;

	private Integer id;

	private static final long serialVersionUID = 1L;

	public ChunkPK() {
		super();
	}

	public Integer getFileid2() {
		return this.fileid2;
	}

	public void setFileid2(Integer fileid2) {
		this.fileid2 = fileid2;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if ( ! (o instanceof ChunkPK)) {
			return false;
		}
		ChunkPK other = (ChunkPK) o;
		return this.id.equals(other.id)
			&& this.fileid2.equals(other.fileid2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.fileid2.hashCode();
		return hash;
	}

}
