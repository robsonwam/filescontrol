package sd.cin.ufpe.br.controller;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;

@Entity
@IdClass(sd.cin.ufpe.br.controller.ChunkPK.class)
public class Chunk implements Serializable {
	//@Id
	//private Integer fileid2;
	
	@EmbeddedId
	private ChunkPK pk;
	
	/*@Id
	@GeneratedValue(strategy=AUTO, generator = "chunk_id_seq")
	@SequenceGenerator(name="chunk_id_seq", sequenceName = "chunk_id_seq")
	private Integer id;*/

	@ManyToOne
	@JoinColumn(name="fileID", insertable = false, updatable = false)
	private Filesd fileid;

	@ManyToMany
	@JoinTable(name="Node_Chunk",
		joinColumns={
			@JoinColumn(name="id", referencedColumnName="id"),
			@JoinColumn(name="fileID", referencedColumnName="fileID")
		}
	,
		inverseJoinColumns={
			@JoinColumn(name="ip", referencedColumnName="ip"),
			@JoinColumn(name="port", referencedColumnName="port")
		}
	)
	private Set<Node> nodeCollection;
    
	

	private static final long serialVersionUID = 1L;

	public Chunk() {
		super();
	}

	public ChunkPK getPk() {
		return this.pk;
	}

	public void setPk(ChunkPK pk) {
		this.pk = pk;
	}

	public Filesd getFileid() {
		return this.fileid;
	}

	public void setFileid(Filesd fileid) {
		this.fileid = fileid;
	}
	public void setFileidDois(Integer fileid) {
	//	this.fileid2 = fileid;
	}

	public Set<Node> getNodeCollection() {
		return this.nodeCollection;
	}

	public void setNodeCollection(Set<Node> nodeCollection) {
		this.nodeCollection = nodeCollection;
	}

}
