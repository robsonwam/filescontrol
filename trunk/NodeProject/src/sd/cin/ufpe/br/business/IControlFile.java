package sd.cin.ufpe.br.business;

import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.List;

import sd.cin.ufpe.br.node.Chunk;
import sd.cin.ufpe.br.node.ChunkPK;
import sd.cin.ufpe.br.node.Node;

public interface IControlFile {
	
	
	
	
	
	
	public boolean addChunk(Chunk chunk);
	public boolean deleteChunkByKey(ChunkPK key);
	public boolean deleteChunk(Chunk chunk);
	public boolean deleteChunksByFile(Integer idFile);
	
	public Object getChunk(int id, int fileID);
	public Object getChunk(ChunkPK key);
	public List<Chunk> listChunks();
	
}