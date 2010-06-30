package sd.cin.ufpe.br.controller;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Node implements Serializable {
	@EmbeddedId
	private NodePK pk;

	private Long numrequisicoes;

	@ManyToMany(mappedBy="nodeCollection")
	private Set<Chunk> chunkCollection;

	private static final long serialVersionUID = 1L;

	public Node() {
		super();
	}

	public NodePK getPk() {
		return this.pk;
	}

	public void setPk(NodePK pk) {
		this.pk = pk;
	}

	public Long getNumrequisicoes() {
		return this.numrequisicoes;
	}

	public void setNumrequisicoes(Long numrequisicoes) {
		this.numrequisicoes = numrequisicoes;
	}

	public Set<Chunk> getChunkCollection() {
		return this.chunkCollection;
	}

	public void setChunkCollection(Set<Chunk> chunkCollection) {
		this.chunkCollection = chunkCollection;
	}

}
