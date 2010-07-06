package br.cin.ufpe.sd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

import br.cin.ufpe.in1118.middleware.distribution.services.naming.Naming;
import br.cin.ufpe.in1118.middleware.distribution.services.naming.NamingService;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;
import br.ufpe.cin.sd.model.business.entities.FileSd;

public class Controller {

	Map<Integer, String> files = null;

	public Map<?, ?> getFiles(String[] extensoes) {
		
		br.ufpe.cin.sd.controller.Controller controller = null;
		Naming naming = NamingService.getNamingInstance("localhost", 9001);
		Map<Integer, String> files = new TreeMap<Integer, String>();
		try {
			Object obj = naming.lookup("controllerService");
			if (obj instanceof Controller) {
				controller = (br.ufpe.cin.sd.controller.Controller) obj;
			}
			
//			controller.registerNode("192.168.0.1",8080);
			files = controller.getFiles();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

//		files.put(1, "Arquivo 1");
//		files.put(2, "Arquivo 2");
//		files.put(3, "Arquivo 3");

		this.files = files;

		return files;

	}

	public Arquivo getFile(Integer id) throws IOException {

		// Create the byte array to hold the data
		br.ufpe.cin.sd.controller.Controller controller = null;
		Naming naming = NamingService.getNamingInstance("localhost", 9001);
		Map<Integer, String> files = new TreeMap<Integer, String>();
		br.ufpe.cin.sd.model.business.entities.FileSd fileSd = null;
		try {
			Object obj = naming.lookup("controllerService");
			if (obj instanceof Controller) {
				controller = (br.ufpe.cin.sd.controller.Controller) obj;
			}
			
//			controller.registerNode("192.168.0.1",8080);
			fileSd = new br.ufpe.cin.sd.model.business.entities.FileSd();
			fileSd.setId(id);
			fileSd = (FileSd) controller.buscarPorChave(fileSd);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		byte[] bytes = fileSd.getFile();
		
		Arquivo arquivo = new Arquivo();
		arquivo.setId(id);
		arquivo.setName(fileSd.getName());

		arquivo.setFile(bytes);
		return arquivo;
	}

	public boolean saveFile(Arquivo arquivo) {

		return true;
	}
}
