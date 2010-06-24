package sd.cin.ufpe.br.node;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Node {

	private NodeState nodeState;
	private ArrayList<Chunk> chunkList;
	private InetAddress ipAddress;
	private int portNumber;
	
	public Node() {
		this.nodeState = nodeState.ALIVE;
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Chunk> getChunkList() {
		return chunkList;
	}
	
	public void setChunkList(ArrayList<Chunk> chunkList) {
		this.chunkList = chunkList;
	}
	//funçao q ira disparar evento pro controlador que ta ativo
	// de 2 em 2 segundos
	public void dispararEvento(){
		 Timer timer = new Timer();
	     TimerTask task = new TimerTask() {
	            public void run() {
	            	System.out.println("Disparando evento " + nodeState);
	            }
	     };
	     timer.scheduleAtFixedRate(task, 0, 2000); 
	}

	public NodeState getNodeState() {
		return nodeState;
	}

	public void setNodeState(NodeState nodeState) {
		this.nodeState = nodeState;
	}

	public InetAddress getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(InetAddress ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
}
