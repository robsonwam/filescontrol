package br.ufpe.cin.sd.model.business.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the chunk database table.
 * 
 */
@Entity
public class Chunk implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChunkPK id;

	//bi-directional many-to-many association to Node
	@ManyToMany(mappedBy="chunks")
	private Set<Node> nodes;

	//bi-directional many-to-one association to FileSd
    @ManyToOne
	@JoinColumn(name="file_id", insertable = false, updatable = false)
	private FileSd fileSd;

    public Chunk() {
    }

	public ChunkPK getId() {
		return this.id;
	}

	public void setId(ChunkPK id) {
		this.id = id;
	}
	
	public Set<Node> getNodes() {
		return this.nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}
	
	public FileSd getFileSd() {
		return this.fileSd;
	}

	public void setFileSd(FileSd fileSd) {
		this.fileSd = fileSd;
	}
	
}