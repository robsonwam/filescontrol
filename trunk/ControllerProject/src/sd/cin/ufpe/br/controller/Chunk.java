package sd.cin.ufpe.br.controller;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Chunk implements Serializable {
	@EmbeddedId
	private ChunkPK pk;

	@ManyToOne
	@JoinColumn(name="fileID")
	private Filesd fileid;

	@ManyToMany
	@JoinTable(name="Node_Chunk",
		joinColumns={
			@JoinColumn(name="id", referencedColumnName="id"),
			@JoinColumn(name="fileID", referencedColumnName="fileID")
		}
	,
		inverseJoinColumns={
			@JoinColumn(name="ip", referencedColumnName="ip"),
			@JoinColumn(name="port", referencedColumnName="port")
		}
	)
	private Set<Node> nodeCollection;

	private static final long serialVersionUID = 1L;

	public Chunk() {
		super();
	}

	public ChunkPK getPk() {
		return this.pk;
	}

	public void setPk(ChunkPK pk) {
		this.pk = pk;
	}

	public Filesd getFileid() {
		return this.fileid;
	}

	public void setFileid(Filesd fileid) {
		this.fileid = fileid;
	}

	public Set<Node> getNodeCollection() {
		return this.nodeCollection;
	}

	public void setNodeCollection(Set<Node> nodeCollection) {
		this.nodeCollection = nodeCollection;
	}

}
