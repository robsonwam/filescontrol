package sd.cin.ufpe.br.controller;

public class Chunk {
	
	private int id;
	private int fileID;
	private byte[] chunkBytes;
	
	public Chunk(int id, int fileID, byte[] chunkBytes) {
		super();
		this.id = id;
		this.fileID = fileID;
		this.chunkBytes = chunkBytes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFileID() {
		return fileID;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	public byte[] getArrayChunk() {
		return chunkBytes;
	}
	public void setArrayChunk(byte[] arrayChunk) {
		this.chunkBytes = arrayChunk;
	}
	
	

}
