package br.ufpe.cin.sd.model.business.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the chunk database table.
 * 
 */
@Embeddable
public class ChunkPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer id;

	@Column(name="file_id")
	private Integer fileId;

    public ChunkPK() {
    }
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFileId() {
		return this.fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ChunkPK)) {
			return false;
		}
		ChunkPK castOther = (ChunkPK)other;
		return 
			this.id.equals(castOther.id)
			&& this.fileId.equals(castOther.fileId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.fileId.hashCode();
		
		return hash;
    }
}