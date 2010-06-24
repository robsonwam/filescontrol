package sd.cin.ufpe.br.node;


public interface INodeFile {
	//teste
	
	public boolean addChunk(Chunk chunk);
	public Chunk getChunk(ChunkPK id);
	public boolean delChunk(ChunkPK id);

}
