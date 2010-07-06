package br.ufpe.cin.sd.model.business.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * The persistent class for the chunk database table.
 * 
 */
@Entity
public class Chunk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@Transient
	byte[] stream;

	//bi-directional many-to-one association to FileSd
    @ManyToOne
	@JoinColumn(name="file_id")
	private FileSd fileSd;

	//bi-directional many-to-many association to Node
	@ManyToMany(mappedBy="chunks")
	private Set<Node> nodes;

    public Chunk() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FileSd getFileSd() {
		return this.fileSd;
	}

	public void setFileSd(FileSd fileSd) {
		this.fileSd = fileSd;
	}
	
	public Set<Node> getNodes() {
		return this.nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	public byte[] getStream() {
		return stream;
	}

	public void setStream(byte[] stream) {
		this.stream = stream;
	}
	
}