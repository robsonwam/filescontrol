package sd.cin.ufpe.br.node;

import java.io.ObjectInput;

public interface INodeFile {
	//teste
	public boolean addChunk(Chunk chunk);
	public Object getChunk(int id);
	public boolean delChunk(int id);

}
