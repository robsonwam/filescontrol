package br.ufpe.cin.sd.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import sd.cin.ufpe.br.business.Node;

import br.cin.ufpe.in1118.middleware.distribution.services.JavaReference;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.Naming;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.NamingService;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;
import br.ufpe.cin.sd.model.business.entities.FileSd;

public class teste2 {
	public static void main(String[] args) {
		
		FileSd fileSd = new FileSd();
		
		Naming naming = NamingService.getNamingInstance("localhost", 9001);
		
		Controller csd =  null;
		try {
			csd = (Controller) naming.lookup("controllerService");
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fileSd = csd.requestFile(3);
		
		 File someFile = new
		 File("C:\\Documents and Settings\\vm1\\Desktop\\leao_10001111.jpg");
		 FileOutputStream fos = null;
		 try {
		 fos = new FileOutputStream(someFile);
		 } catch (FileNotFoundException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 try {
		 fos.write( fileSd.getFile());
		 fos.flush();
		 fos.close();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
//		
		

//		File file = new File(
//				"C:\\Documents and Settings\\vm1\\Desktop\\leao_11.jpg");
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// System.out.println(file.exists() + "!!");
//		// InputStream in = resource.openStream();
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		byte[] buf = new byte[1024];
//		try {
//			for (int readNum; (readNum = fis.read(buf)) != -1;) {
//				bos.write(buf, 0, readNum); // no doubt here is 0
//				// Writes len bytes from the specified byte array starting at
//				// offset off to this byte array output stream.
//				System.out.println("read " + readNum + " bytes,");
//			}
//		} catch (IOException ex) {
//			// Logger.getLogger(genJpeg.class.getName()).log(Level.SEVERE, null,
//			// ex);
//		}
//		byte[] bytes = bos.toByteArray();
//
//		Naming naming = NamingService.getNamingInstance("localhost", 9001);
//		
//		Controller csd =  null;
//		try {
//			csd = (Controller) naming.lookup("controllerService");
//		} catch (RemoteException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		FileSd filesd = new FileSd();
//		filesd.setName("Arquivo_Novo");
//		filesd.setFile(bytes);
//
//		csd.inserir(filesd);

		// Monta o arquivo
		// System.out.println(bytes.length);
		// System.out.println(5%5);
		//	        
		// ControllerSD c = new ControllerSD();
		// ArrayList<Chunk_old> ac = c.chunkonizer(bytes);
		// //
		// //csd.AddChunk(1);
		// //
		// byte[] restoredFile = new byte[40747];
		// int index = 0;
		// for (int i = 0; i < ac.size(); i++) {
		// System.arraycopy(ac.get(i).getArrayChunk(), 0, restoredFile, index,
		// ac.get(i).getArrayChunk().length);
		// index = index + ac.get(i).getArrayChunk().length;
	}
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
