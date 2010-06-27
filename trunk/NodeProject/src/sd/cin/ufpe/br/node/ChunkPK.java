package sd.cin.ufpe.br.node;

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

	private int id;
	
	private int fileID;
	
    
	public ChunkPK() {
    }
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFileID() {
		return this.fileID;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
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
			(this.id == castOther.id)
			&& (this.fileID == castOther.fileID);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.fileID;
		
		return hash;
    }
}