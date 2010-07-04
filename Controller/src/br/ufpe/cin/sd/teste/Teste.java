package br.ufpe.cin.sd.teste;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import br.ufpe.cin.sd.controller.Controller;
import br.ufpe.cin.sd.exceptions.OperacaoInvalidaException;
import br.ufpe.cin.sd.model.business.entities.Arquivo;
import br.ufpe.cin.sd.model.business.entities.Node;
import br.ufpe.cin.sd.model.business.entities.NodePK;

public class Teste {

	public static void main(String[] args) throws OperacaoInvalidaException {

		 Node node = new Node();
		 NodePK pk = new NodePK();
		 pk.setIp("192.168.0.1");
		 pk.setPort(80);
		 node.setId(pk);
		// node.setNumRequisicoes(0);
		 Controller controller = new Controller();
		 controller.registerNode("192.168.0.1", 80,true);

//		File file = new File(
//				"/home/robson/Imagem-FileReference.jpg");
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
//		Arquivo arquivo = new Arquivo();
//		arquivo.setName("Teste");
//		arquivo.setFile(bytes);
//		Controller controller = new Controller();
//		controller.inserir(arquivo);
	}

}
