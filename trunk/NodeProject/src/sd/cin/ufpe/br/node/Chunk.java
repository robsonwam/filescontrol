package sd.cin.ufpe.br.node;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chunk database table.
 * 
 */
@Entity
@Table(name="chunk")
public class Chunk implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChunkPK id;

    @Lob()
	private byte[] stream;

    public Chunk() {
    }

	public ChunkPK getId() {
		return this.id;
	}

	public void setId(ChunkPK id) {
		this.id = id;
	}
	
	public byte[] getStream() {
		return this.stream;
	}

	public void setStream(byte[] stream) {
		this.stream = stream;
	}

}