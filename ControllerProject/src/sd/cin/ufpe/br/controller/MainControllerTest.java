package sd.cin.ufpe.br.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainControllerTest {
	
	public static void main(String[] args) {
		
			File file = new File("/Users/davidaragao/Desktop/android_ico.png");
	        FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //System.out.println(file.exists() + "!!");
	        //InputStream in = resource.openStream();
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        byte[] buf = new byte[1024];
	        try {
	            for (int readNum; (readNum = fis.read(buf)) != -1;) {
	                bos.write(buf, 0, readNum); //no doubt here is 0
	                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
	                System.out.println("read " + readNum + " bytes,");
	            }
	        } catch (IOException ex) {
	            //Logger.getLogger(genJpeg.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        byte[] bytes = bos.toByteArray();
	        System.out.println(bytes.length);
	        
	        ControllerSD c = new ControllerSD();
	        ArrayList<Chunk> ac = c.chunkonizer(bytes);
	        
	        byte[] restoredFile = new byte[5194];
	        int index = 0;
	        for (int i = 0; i < ac.size(); i++) {
				System.arraycopy(ac.get(i).getArrayChunk(), 0, restoredFile, index, ac.get(i).getArrayChunk().length);
				index = index + ac.get(i).getArrayChunk().length;
			}
	        
	        File someFile = new File("/Users/davidaragao/Desktop/android_ico_restored.png");
	        FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(someFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				fos.write( restoredFile);
				fos.flush();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}

}
