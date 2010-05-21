package sd.cin.ufpe.br.controller;

import java.io.ObjectInput;
import java.util.ArrayList;

import sd.cin.ufpe.br.node.Node;

public interface IControlFile {
	
	public boolean addNode(Node node);
	public boolean deleteNode(Node node);
	public boolean addFile(ObjectInput file);
	public ObjectInput getFile(String name);
	public boolean delFile(String name);
	public ArrayList<String> listFiles();
}
