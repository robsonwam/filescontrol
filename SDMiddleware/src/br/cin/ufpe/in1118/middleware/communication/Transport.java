package br.cin.ufpe.in1118.middleware.communication;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

/**
 * @author  arss
 */
public abstract class Transport{

	private Buffer buffer;
	
	private boolean server;
	
	public Transport(boolean isServer) {
		this.buffer = new Buffer();
		this.server = isServer;
	}
	
	public Buffer getBuffer(){
		return this.buffer;
	}
	
	public boolean isServer() {
		return server;
	}
	
	public abstract void send() throws RemoteException;
	
	public abstract void receive() throws RemoteException;

	public abstract boolean isAlive();

	public abstract void close();
	
}
