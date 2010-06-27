package sd.cin.ufpe.br.controller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;


public class ControllerSD {
	
	private ArrayList<NodeSD> arrayNodes; //list the registered nodes
	private int lastNodeID; //last node called ID
	private Hashtable<String, Integer> fileNameToID; //Maps the file name to it`s ID
	private Hashtable<Integer, ArrayList<Integer>> fileIDToChunksIDArray; //Maps the file ID to it`s chunksIDArray
	
	//Receives client application file
	public void ReceiveFile(File file/*receber FileSD ou File*/){
		//[1]Associar o nome do arquivo ao seu ID e por na hash
		
		int fileID = fileIDGenerator(); 
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
			for (int readNum; (readNum = fileIS.read(buf)) != -1;) {
				bos.write(buf, 0, readNum); //no doubt here is 0
				
				ByteOutputStream bosChunk = new ByteOutputStream();
				bosChunk.write(buf, 0, readNum);
				byte[] chunkBytes = bos.toByteArray();
				int chunkID = chunkIDGenerator();
				Chunk chunk = new Chunk(chunkID, fileID, chunkBytes);
				chunksIdList.add(chunkID);
				// Ou envia o chunk logo aqui ou cria uma lista de chunks para ser usada em [4]
				
			}
		} catch (IOException ex) {
			
		}
		byte[] bytes = bos.toByteArray();
		
		FileSD filesd = new FileSD(fileID, file.getName(), 2, bytes);
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
	public Chunk[] chunkonizer(FileSD file){
		Chunk[] arrayChunks = null;
		return arrayChunks;
	}
	
	//Method that distribute the chunks between the registered nodes
	public void distributeChunks(Chunk[] arrayChunks){
		
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
		return generatedID;
	}
	
	public int chunkIDGenerator(){
		int generatedID = 0;
		return generatedID;
	}
}
