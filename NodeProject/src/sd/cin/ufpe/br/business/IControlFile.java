package sd.cin.ufpe.br.business;

import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.List;

import sd.cin.ufpe.br.node.Chunk;
import sd.cin.ufpe.br.node.ChunkPK;
import sd.cin.ufpe.br.node.Node;

public interface IControlFile {
	
	public boolean addNode(Node node);
	public boolean deleteNode(Node node);
	public boolean addFile(Object file);
	public Object getFile(String name);
	
	//
	public boolean delFile(Integer idFile);
	
	public List<String> listFiles();
	
	public boolean addChunk(Chunk chunk);
	public boolean deleteChunkByKey(ChunkPK key);
	public boolean deleteChunk(Chunk chunk);
	public Object getChunk(int idFile, int sequencia);
	public Object getChunk(ChunkPK key);
	public List<Chunk> listChunks();
	
}