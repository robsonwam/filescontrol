package br.cin.ufpe.in1118.middleware.distribution;

import br.cin.ufpe.in1118.middleware.communication.Address;
import br.cin.ufpe.in1118.middleware.communication.Transport;
import br.cin.ufpe.in1118.middleware.distribution.message.SOAPFactory;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class Middleware {

	private Invoker invoker;
	private Requestor requestor;
	private Transport transport;
		
	public Middleware(Address<?> address) {
		this.transport = address.getTransportNewTransportIntance();
	}
	
	public void addService(Object key, Object object) {
		if (this.invoker == null) {
			this.invoker = new Invoker(this.transport);
		}
		this.invoker.addService(key, object);
	}
	
	public void run(){
		if (this.invoker == null) {
			this.invoker = new Invoker(this.transport);
		}
		this.invoker.init();
	}

	public Object invokeJava(Object objectId, String operation, Object... parameters) throws RemoteException {
		if (this.requestor == null) {
			this.requestor = new Requestor(this.transport);
		}
		return this.requestor.invokeJava(objectId, operation, parameters);
	}
	
	public Object invokeWS(SOAPFactory wsdlAddress, String operation, Object... parameters) throws RemoteException {
		if (this.requestor == null) {
			this.requestor = new Requestor(this.transport);
		}
		return this.requestor.invokeWS(wsdlAddress, operation, parameters);
	}
}
