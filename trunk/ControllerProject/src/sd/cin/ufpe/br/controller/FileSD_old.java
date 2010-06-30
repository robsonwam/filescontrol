package sd.cin.ufpe.br.controller;

public class FileSD_old { //Extender de File?
	
	private int id;
	private String name;
	private int numberOfChunks;
	private byte[] arrayFileSD; // trocar por File
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfChunks() {
		return numberOfChunks;
	}

	public void setNumberOfChunks(int numberOfChunks) {
		this.numberOfChunks = numberOfChunks;
	}

	public byte[] getArrayFileSD() {
		return arrayFileSD;
	}

	public void setArrayFileSD(byte[] arrayFileSD) {
		this.arrayFileSD = arrayFileSD;
	}

	public FileSD_old(int id, String name, int numberOfChunks, byte[] bs) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfChunks = numberOfChunks;
		this.arrayFileSD = bs;
	}
	

}
