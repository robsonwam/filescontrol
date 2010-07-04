package sd.cin.ufpe.br.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sd.cin.ufpe.br.business.ChunkController;
import sd.cin.ufpe.br.entities.Chunk;
import sd.cin.ufpe.br.exceptions.ExclusaoInvalidaException;
import sd.cin.ufpe.br.exceptions.OperacaoInvalidaException;


public class TestMain {
	public static void main(String[] args) throws OperacaoInvalidaException, ExclusaoInvalidaException {
					
		ChunkController business = new ChunkController();	
		
		try {	
			File file = new File("c:\\Users\\salvio\\Documents\\pagamento1.jpg");
			FileInputStream fileStream;
			
				fileStream = new FileInputStream(file);
			
			
			byte[] bytes = fileStream.toString().getBytes();
			fileStream = new FileInputStream(file);
			
		
			Chunk chunk = new Chunk();
			chunk.setId(2);
			chunk.setFileId(8);
			chunk.setStream(bytes);
			//business.inserir(chunk);
			business.remover(chunk);
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
}
