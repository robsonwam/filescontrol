package br.ufpe.cin.sd.model.business.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the node database table.
 * 
 */
@Entity
public class Node implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NodePK id;

	@Column(name="num_requisicoes")
	private Integer numRequisicoes;

	//bi-directional many-to-many association to Chunk
    @ManyToMany
	@JoinTable(
		name="node_chunk"
		, joinColumns={
			@JoinColumn(name="ip", referencedColumnName="ip"),
			@JoinColumn(name="port", referencedColumnName="port")
			}
		, inverseJoinColumns={
			@JoinColumn(name="file_id", referencedColumnName="file_id"),
			@JoinColumn(name="id", referencedColumnName="id")
			}
		)
	private Set<Chunk> chunks;

    public Node() {
    }

	public NodePK getId() {
		return this.id;
	}

	public void setId(NodePK id) {
		this.id = id;
	}
	
	public Integer getNumRequisicoes() {
		return this.numRequisicoes;
	}

	public void setNumRequisicoes(Integer numRequisicoes) {
		this.numRequisicoes = numRequisicoes;
	}

	public Set<Chunk> getChunks() {
		return this.chunks;
	}

	public void setChunks(Set<Chunk> chunks) {
		this.chunks = chunks;
	}
	
}