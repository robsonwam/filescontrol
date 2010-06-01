package sd.cin.ufpe.br.node;

import java.io.ObjectInput;

public interface INodeFile {
	//teste
	public boolean addChunk(int id, ObjectInput file);
	public ObjectInput getChunk(int id);
	public boolean delChunk(int id);

}
