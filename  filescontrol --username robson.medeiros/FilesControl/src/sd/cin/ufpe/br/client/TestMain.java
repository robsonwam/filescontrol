package sd.cin.ufpe.br.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInput;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import sd.cin.ufpe.br.node.Chunk;
import sd.cin.ufpe.br.node.ChunkDAO;
import sd.cin.ufpe.br.node.GenericDAO;
import sd.cin.ufpe.br.node.Node;


public class TestMain {
	public static void main(String[] args) {
		
		
		
		
		File file = new File("c:\\planilha1.xls");
		FileInputStream fileStream;
		
		GenericDAO<Chunk> chunkDAO = new ChunkDAO();		
		chunkDAO.begin();
		
		try {
			
			
			List<Chunk> list = chunkDAO.buscarTodos();
			for (Chunk chunk : list) {
				System.out.println("ID:" + chunk.getId() + " / Nome" + chunk.getStream().toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally{
			chunkDAO.close();
		}
		
	}
}
