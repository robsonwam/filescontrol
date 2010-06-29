package sd.cin.ufpe.br.controller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;


public class ControllerSD {
	
	private ArrayList<NodeSD> arrayNodes; //list the registered nodes
	private int lastNodeID; //last node called ID
	private Hashtable<String, Integer> fileNameToID; //Maps the file name to it`s ID
	private Hashtable<Integer, ArrayList<Integer>> fileIDToChunksIDArray; //Maps the file ID to it`s chunksIDArray
	private ArrayList<Chunk> chunkList;
	byte[] fileBytes;
	int fileID;
	
	//Receives client application file
	public void ReceiveFile(File file/*receber FileSD ou File*/){
		//[1]Associar o nome do arquivo ao seu ID e por na hash
		
		fileID = fileIDGenerator(); 
		ArrayList<Integer> chunksIdList = null;
		
		FileInputStream fileIS = null;
		try {
			fileIS = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		try {
			int chunkID = 0;
			for (int readNum; (readNum = fileIS.read(buf)) != -1;) {
				bos.write(buf, 0, readNum); //no doubt here is 0
			}
			
		} catch (IOException ex) {
			
		}
		fileBytes = bos.toByteArray();
		
		FileSD filesd = new FileSD(fileID, file.getName(), 2, fileBytes);
		fileNameToID.put(filesd.getName(), filesd.getId());
		fileIDToChunksIDArray.put(fileID, chunksIdList);
		
		
		//[4]Distribuir os chunks entre os nós
	}
	
	//Register incoming nodes
	public void registerNode(String ip, String port){
		//deve receber o "endereço" do nó e mapear a um ID.... serviço de nomes?
	}
	
	//Deregister outcoming nodes
	public void deregisterNode(){
		
	}
	
	//Method that break the file in chunks
	public ArrayList<Chunk> chunkonizer(byte[] fileArray){
		ArrayList<Chunk> chunkList = new ArrayList<Chunk>();
		int index = 0;
		int chunkLength = fileArray.length/3 /*arrayNodes.size()*/;
		int rest = fileArray.length%3;
		byte[] arrayChunk;
		
		for (int i = 0; i < 3/*arrayNodes.size()*/; i++) {
			if (i == 2) {
				arrayChunk = new byte[chunkLength + rest];
				System.arraycopy(fileArray, index, arrayChunk, 0, chunkLength + rest);
			} else {
				arrayChunk = new byte[chunkLength];
				System.arraycopy(fileArray, index, arrayChunk, 0, chunkLength);
				index = index + chunkLength;
			}
			Chunk chunk = new Chunk(i, 1, arrayChunk);
			chunkList.add(chunk);
		}
		
		// Ou envia o chunk logo aqui ou cria uma lista de chunks para ser usada em [4]
		return chunkList;
	}
	
	//Method that send the chunks between the registered nodes
	public ArrayList<Chunk> sendChunkList(){
		//Pegar a lista de chunks e mandar n listas
		//contentod n-1 chunks para os n nos
		return chunkList;
	}
	
	//Method that retrieve requested file
	public FileSD retrieveFileSD(int fileID){
		FileSD file = null;
		return file;
		
		//Busca os chunks
		//montar o array do arquivo
		//retornar um FileSD
	}
	
	public int fileIDGenerator(){
		int generatedID = 0;
		Random random = new Random();
		generatedID = random.nextInt(9999);
		return generatedID;
	}
	
//	public int chunkIDGenerator(){
//		int generatedID = 0;
//		return generatedID;
//	}
}
