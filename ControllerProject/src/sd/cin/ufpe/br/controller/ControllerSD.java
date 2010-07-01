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
import java.util.List;
import java.util.Random;

import br.cin.ufpe.sd.Arquivo;

import sd.cin.ufpe.br.controller.dao.ChunkDAO;
import sd.cin.ufpe.br.controller.dao.FilesSdDAO;
import sd.cin.ufpe.br.controller.dao.NodeDAO;

public class ControllerSD {

	private ArrayList<Node_old> arrayNodes; // list the registered nodes
	private int lastNodeID; // last node called ID
	private Hashtable<String, Integer> fileNameToID; // Maps the file name to
	private Hashtable<Integer, ArrayList<Integer>> fileIDToChunksIDArray;
	private ArrayList<Chunk_old> chunkList;
	byte[] fileBytes;
	int fileID;

	private NodeDAO nodeDao;
	private FilesSdDAO fileDao;
	private ChunkDAO chunkDao;
	

	public ControllerSD() {
		super();
		this.nodeDao = NodeDAO.getInstance();
		this.fileDao = FilesSdDAO.getInstance();
		this.chunkDao = ChunkDAO.getInstance();
	}

	// Receives client application file
	public void ReceiveFile(Arquivo file/* receber FileSD ou File */) {

		// adiciona a referencia do id ao nome;
		Filesd fileSd = new Filesd();
		fileSd.setName(file.getName());
		
		AddFile(fileSd);
		int fileID = fileSd.getId();
		
		//Transforma o arquivo em array de bytes
		ArrayList<Integer> chunksIdList = null;

		FileInputStream fileIS = null;
		try {
			fileIS = new FileInputStream(file.getName());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		try {
			int chunkID = 0;
			for (int readNum; (readNum = fileIS.read(buf)) != -1;) {
				bos.write(buf, 0, readNum); // no doubt here is 0
			}

		} catch (IOException ex) {

		}
		//Arquivo em bytes
		fileBytes = bos.toByteArray();
		
		this.chunkList = this.chunkonizer(fileBytes, fileID);
		
		this.sendChunkList(this.chunkList);
	}

	public boolean AddFile(Filesd file) {
		boolean result = false;
		try {
			if (!file.getName().isEmpty()) {
				
				fileDao.begin();
				fileDao.salvar(file);
				fileDao.commit();
				result = true;
			}
		} catch (Exception e) {
			fileDao.rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean AddChunk(Integer fileId){
		boolean result = false;
		
		try {
			if (fileId != null) {
				ChunkPK cpk = new ChunkPK();
				cpk.setFileid2(fileId);
				Chunk chunk = new Chunk();
				chunk.setPk(cpk);
				//setar o conjunto de nos que o chunk 
				
				chunkDao.begin();
				chunkDao.salvar(chunk);
				chunkDao.commit();
				result = true;
			}
		} catch (Exception e) {
			chunkDao.rollback();
			e.printStackTrace();
		}
		
		return result;
	}

	// Register incoming nodes
	public boolean registerNode(String ip, Integer port) {

		boolean result = false;
		try {
			if (!ip.isEmpty() && port != null) {
				NodePK pk = new NodePK();
				pk.setIp(ip);
				pk.setPort(port);
				Node node = new Node();
				node.setPk(pk);
				node.setNumrequisicoes(0L);

				nodeDao.begin();
				nodeDao.salvar(node);
				nodeDao.commit();
				result = true;
			}
		} catch (Exception e) {
			nodeDao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	// Deregister outcoming nodes
	public boolean deregisterNode(String ip, Integer port) {
		boolean result = false;

		try {
			if (!ip.isEmpty() && port != null) {
				nodeDao.begin();
				nodeDao.removerPorChave(ip, port);
				nodeDao.commit();
				result = true;
				return result;
			}
		} catch (Exception e) {
			nodeDao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	// Method that break the file in chunks
	public ArrayList<Chunk_old> chunkonizer(byte[] fileArray, int fileID) {
		ArrayList<Chunk_old> chunkOldList = new ArrayList<Chunk_old>();
		List<Chunk> chunkList = chunkDao.buscarTodos();
		int index = 0;
		int chunkLength = fileArray.length / chunkList.size();
		int rest = fileArray.length % chunkList.size();
		byte[] arrayChunk;

		for (int i = 0; i < chunkList.size(); i++) {
			if (i == chunkList.size()-1) {
				arrayChunk = new byte[chunkLength + rest];
				System.arraycopy(fileArray, index, arrayChunk, 0, chunkLength
						+ rest);
			} else {
				arrayChunk = new byte[chunkLength];
				System.arraycopy(fileArray, index, arrayChunk, 0, chunkLength);
				index = index + chunkLength;
			}
			Chunk_old chunkOld = new Chunk_old(i, 1, arrayChunk);
			this.AddChunk(fileID);
			chunkOldList.add(chunkOld);
		}

		// Ou envia o chunk logo aqui ou cria uma lista de chunks para ser usada
		// em [4]
		return chunkOldList;
	}

	// Method that send the chunks between the registered nodes
	public Chunk_old sendChunkList(ArrayList<Chunk_old> chunklist) {
		Chunk_old chunk = null;
		
		//Enviar os chunks para os nos registrados
		
		return chunk;
	}

	// Method that retrieve requested file
	public FileSD_old retrieveFileSD(int fileID) {
		FileSD_old file = null;
		return file;

		// Busca os chunks
		// montar o array do arquivo
		// retornar um FileSD
	}

	public int iDGenerator() {
		int generatedID = 0;
		Random random = new Random();
		generatedID = random.nextInt(9999);
		return generatedID;
	}

	// public int chunkIDGenerator(){
	// int generatedID = 0;
	// return generatedID;
	// }
}
