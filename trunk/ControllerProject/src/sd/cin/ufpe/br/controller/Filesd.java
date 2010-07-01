package sd.cin.ufpe.br.controller;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.TemporalType.TIME;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.SequenceGenerator;

@Entity
public class Filesd implements Serializable {
	@Id
	@GeneratedValue(strategy=AUTO, generator = "filesd_id_seq")
	@SequenceGenerator(name="filesd_id_seq", sequenceName = "filesd_id_seq")
	private Integer id; 

	private String name;

	@OneToMany(mappedBy="fileid")
	private Set<Chunk> chunkCollection;

	private static final long serialVersionUID = 1L;

	public Filesd() {
		super();
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

	public Set<Chunk> getChunkCollection() {
		return this.chunkCollection;
	}

	public void setChunkCollection(Set<Chunk> chunkCollection) {
		this.chunkCollection = chunkCollection;
	}

}
