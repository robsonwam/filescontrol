package sd.cin.ufpe.br.tests;

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

import sd.cin.ufpe.br.business.NodeBusiness;
import sd.cin.ufpe.br.node.Chunk;
import sd.cin.ufpe.br.node.ChunkPK;
import sd.cin.ufpe.br.node.Node;


public class TestMain {
	public static void main(String[] args) {
					
		NodeBusiness business = new NodeBusiness();	
		
		try {	
			File file = new File("c:\\Users\\salvio\\Documents\\pagamento1.jpg");
			FileInputStream fileStream;
			
				fileStream = new FileInputStream(file);
			
			
			byte[] bytes = fileStream.toString().getBytes();
			fileStream = new FileInputStream(file);
			
		
			Chunk chunk = new Chunk();
			
			chunk.setStream(bytes);
			ChunkPK pk = new ChunkPK();
						
			pk.setId(1);
			pk.setSequencia(3);
			chunk.setId(pk);
			
			//business.addChunk(chunk);
			boolean test =  business.delFile(1);
			System.out.println(test);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
}
