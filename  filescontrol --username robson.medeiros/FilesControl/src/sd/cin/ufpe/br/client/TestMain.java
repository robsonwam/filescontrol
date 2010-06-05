package sd.cin.ufpe.br.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInput;
import java.io.Reader;

import sd.cin.ufpe.br.node.Chunk;
import sd.cin.ufpe.br.node.ChunkDAO;


public class TestMain {
	public static void main(String[] args) {
		
		ChunkDAO chunkDAO = new ChunkDAO();		
		
		/*
		 * Criando o objeto usuário
		 */
		
		File file = new File("c:\\planilha1.xls");
		FileInputStream fileStream;
		
		try {
			fileStream = new FileInputStream(file);
			
			byte currentBytes[] = fileStream.toString().getBytes();
			  
			//ByteArrayInputStream bytes = new ByteArrayInputStream(currentBytes);
			
			
			Chunk chunk = new Chunk();
			chunk.setIdCHunk(1);
			chunk.setStream(currentBytes);
			
			chunkDAO.addChunk(chunk);
			//chunk.setIdCHunk(1);
			
			ChunkDAO chunkDAO1 = new ChunkDAO();
			Object result = chunkDAO1.getChunk(30);
			
			byte[] arquivo = ((Chunk) result).getStream();
			System.out.println("Nome:" + arquivo);
			
			ByteArrayInputStream bytes = new ByteArrayInputStream(arquivo);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		

	}
}
