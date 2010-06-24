package br.cin.ufpe.sd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

public class Controller {

	Map<Integer, String> files = null;

	public Map<?, ?> getFiles(String[] extensoes) {
		Map<Integer, String> files = new TreeMap<Integer, String>();

		files.put(1, "Arquivo 1");
		files.put(2, "Arquivo 2");
		files.put(3, "Arquivo 3");

		this.files = files;

		return files;

	}

	public Arquivo getFile(Integer id) throws IOException {
		Arquivo arquivo = new Arquivo();
		arquivo.setId(id);
		arquivo.setName(this.files.get(id));
		File file = new File("Files/Teste.txt");

		InputStream is = new FileInputStream(file);

		// Get the size of the file
		long length = file.length();

		// You cannot create an array using a long type.
		// It needs to be an int type.
		// Before converting to an int type, check
		// to ensure that file is not larger than Integer.MAX_VALUE.
		if (length > Integer.MAX_VALUE) {
			// File is too large
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		// Close the input stream and return bytes
		is.close();

		arquivo.setFile(bytes);
		return arquivo;
	}

	public boolean saveFile(Arquivo arquivo) {

		return true;
	}
}
