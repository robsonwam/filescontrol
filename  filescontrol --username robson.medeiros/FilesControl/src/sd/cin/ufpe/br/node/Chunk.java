package sd.cin.ufpe.br.node;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Chunk")

public class Chunk {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idCHunk;
		
	    @Column(name="stream")
		private byte[] stream;
		
		public Chunk() {
			// TODO Auto-generated constructor stub
		}
		public Chunk(int idChunk, byte[] stream) {
			// TODO Auto-generated constructor stub
			this.idCHunk = idChunk;
			this.stream = stream;
		}
		
		public int getIdCHunk() {
			return idCHunk;
		}
		
		public void setIdCHunk(int idCHunk) {
			this.idCHunk = idCHunk;
		}
		
		public byte[] getStream() {
			return stream;
		}
		
		public void setStream(byte[] stream) {
			this.stream = stream;
		}
		
		
		
}
