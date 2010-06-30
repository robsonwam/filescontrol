package sd.cin.ufpe.br.controller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;


public class ControllerSD {
	
	private ArrayList<Node_old> arrayNodes; //list the registered nodes
	private int lastNodeID; //last node called ID
	private Hashtable<String, Integer> fileNameToID; //Maps the file name to it`s ID
	private Hashtable<Integer, ArrayList<Integer>> fileIDToChunksIDArray; //Maps the file ID to it`s chunksIDArray
	private ArrayList<Chunk_old> chunkList;
	byte[] fileBytes;
	int fileID;
	
	//Receives client application file
	public void ReceiveFile(File file/*receber FileSD ou File*/){
		//[1]Associar o nome do arquivo ao seu ID e por na hash
		
		fileID = iDGenerator(); 
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
		
		FileSD_old filesd = new FileSD_old(fileID, file.getName(), 2, fileBytes);
		fileNameToID.put(filesd.getName(), filesd.getId());
		fileIDToChunksIDArray.put(fileID, chunksIdList);
		
		
		//[4]Distribuir os chunks entre os n—s
	}
	
	//Register incoming nodes
	public void registerNode(String ip, String port){
		Node_old node = new Node_old(ip, port);
		//Persistir node
	}
	
	//Deregister outcoming nodes
	public void deregisterNode(String ip, String port){
		//Buscar node com ip porta e remover
	}
	
	//Method that break the file in chunks
	public ArrayList<Chunk_old> chunkonizer(byte[] fileArray){
		ArrayList<Chunk_old> chunkList = new ArrayList<Chunk_old>();
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
			Chunk_old chunk = new Chunk_old(i, 1, arrayChunk);
			chunkList.add(chunk);
		}
		
		// Ou envia o chunk logo aqui ou cria uma lista de chunks para ser usada em [4]
		return chunkList;
	}
	
	//Method that send the chunks between the registered nodes
	public Chunk_old sendChunkList(ArrayList<Chunk_old> chunklist){
		//Pegar a lista de chunks e mandar n listas
		//contentdo n-1 chunks para os n nos
		
		
//		Iterator it = chunkList.iterator();
//		int index = 0;
//		for (int i = 0; i < 3 /*arrayNodes.size()*/; i++) {
//			ArrayList<Chunk> nodeChunkList = new ArrayList<Chunk>(3);
//			for (int j = 0; j < 3-1 /*arrayNodes.size()-1*/; j++) {
//				nodeChunkList.add(chunklist.get((j + index)%3));
//			}
//			index++;
//			//enviar para os nós cadastrados
//		}
		Chunk_old chunk = null;
		return chunk;
	}
	
	//Method that retrieve requested file
	public FileSD_old retrieveFileSD(int fileID){
		FileSD_old file = null;
		return file;
		
		//Busca os chunks
		//montar o array do arquivo
		//retornar um FileSD
	}
	
	public int iDGenerator(){
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
