package sd.cin.ufpe.br.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import br.cin.ufpe.sd.Arquivo;

import sd.cin.ufpe.br.controller.dao.NodeDAO;

public class MainControllerTest {

	public static void main(String[] args) {

		File file = new File(
				"C:\\Documents and Settings\\Administrador\\Desktop\\Eclipse-XaaS.png");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(file.exists() + "!!");
		// InputStream in = resource.openStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		try {
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum); // no doubt here is 0
				// Writes len bytes from the specified byte array starting at
				// offset off to this byte array output stream.
				System.out.println("read " + readNum + " bytes,");
			}
		} catch (IOException ex) {
			// Logger.getLogger(genJpeg.class.getName()).log(Level.SEVERE, null,
			// ex);
		}
		byte[] bytes = bos.toByteArray();

		ControllerSD csd = new ControllerSD();
		//csd.registerNode("localhost", 7777);
		Filesd fileS = new Filesd();
		fileS.setName("Teste");
		
		Arquivo teste = new Arquivo();
		teste.setName("au au");
		teste.setFile(bytes);
		//Set hashSet = new HashSet(csd.chunkonizer(bytes));
		//fileS.setChunkCollection(hashSet);
		
		csd.AddFile(fileS);
		
//		csd.ReceiveFile(teste);
		
//		csd.deregisterNode("localhost", 7777);
//		csd.retrieveFileSD(1);

		
		//Monta o arquivo
		// System.out.println(bytes.length);
		// System.out.println(5%5);
		//	        
		// ControllerSD c = new ControllerSD();
		// ArrayList<Chunk_old> ac = c.chunkonizer(bytes);
		//	        
		// c.sendChunkList(ac);
		//	        
		// byte[] restoredFile = new byte[40747];
		// int index = 0;
		// for (int i = 0; i < ac.size(); i++) {
		// System.arraycopy(ac.get(i).getArrayChunk(), 0, restoredFile, index,
		// ac.get(i).getArrayChunk().length);
		// index = index + ac.get(i).getArrayChunk().length;
		// }
		//	        
		// File someFile = new
		// File("C:\\Documents and Settings\\Administrador\\Desktop\\Eclipse-XaaS_restored.png");
		// FileOutputStream fos = null;
		// try {
		// fos = new FileOutputStream(someFile);
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// fos.write( restoredFile);
		// fos.flush();
		// fos.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		//		
		// }

	}
}
