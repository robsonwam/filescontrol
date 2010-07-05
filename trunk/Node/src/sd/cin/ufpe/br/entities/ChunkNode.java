package sd.cin.ufpe.br.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chunk database table.
 * 
 */
@Entity(name="chunk")
public class ChunkNode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="file_id")
	private Integer fileId;

	private byte[] stream;

    public ChunkNode() {
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

	public byte[] getStream() {
		return this.stream;
	}

	public void setStream(byte[] stream) {
		this.stream = stream;
	}

}