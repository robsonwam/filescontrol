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
		private int id;
		
	    @Column(name="stream")
		private byte[] stream;
		
		public Chunk() {
			// TODO Auto-generated constructor stub
			super();
		}
		public Chunk(int id, byte[] stream) {
			// TODO Auto-generated constructor stub
			this.id = id;
			this.stream = stream;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public byte[] getStream() {
			return stream;
		}
		
		public void setStream(byte[] stream) {
			this.stream = stream;
		}
		
		
		
}
