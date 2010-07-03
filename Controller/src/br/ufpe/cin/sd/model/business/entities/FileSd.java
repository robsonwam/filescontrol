package br.ufpe.cin.sd.model.business.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the file_sd database table.
 * 
 */
@Entity
@Table(name="file_sd")
public class FileSd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Chunk
	@OneToMany(mappedBy="fileSd")
	private Set<Chunk> chunks;

    public FileSd() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Chunk> getChunks() {
		return this.chunks;
	}

	public void setChunks(Set<Chunk> chunks) {
		this.chunks = chunks;
	}
	
}