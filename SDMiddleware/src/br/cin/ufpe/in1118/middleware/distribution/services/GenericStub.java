package br.cin.ufpe.in1118.middleware.distribution.services;

import br.cin.ufpe.in1118.middleware.communication.Address;
import br.cin.ufpe.in1118.middleware.communication.HTTPAddress;
import br.cin.ufpe.in1118.middleware.communication.TCPAddress;
import br.cin.ufpe.in1118.middleware.distribution.Middleware;
import br.cin.ufpe.in1118.middleware.distribution.message.SOAPFactory;
import br.cin.ufpe.in1118.middleware.distribution.services.util.MiddlewareUtil;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public abstract class GenericStub {

	private ObjectReference objectReference;
	private Middleware middleware;

	public GenericStub(ObjectReference objectReference) {
		this.objectReference = objectReference;
		Address<?> address = null;
		if (objectReference instanceof JavaReference) {
			JavaReference jr = (JavaReference) objectReference;
			address = new TCPAddress(jr.getHost(), jr.getPort());
		} else if (objectReference instanceof WSReference) {
			WSReference ws = (WSReference) objectReference;
			address = new HTTPAddress(ws.getURL());
		} else {
			throw new IllegalArgumentException("Invalid code!");
		}
		this.middleware = new Middleware(address);
	}

	protected Object execute(String operationName, Object... parameters) throws RemoteException {
		Object ret = null;

		try {
			if (this.objectReference instanceof JavaReference) {
				ret = this.middleware.invokeJava(((JavaReference) this.objectReference).getObjectId(), operationName, parameters);
			} else if (this.objectReference instanceof WSReference) {
				String interfaceName = this.objectReference.getInterfaceName();
				Class<?> forName = Class.forName(interfaceName + "_SF");
				Object obj = forName.newInstance();
				ret = this.middleware.invokeWS((SOAPFactory) obj, operationName, parameters);
			}
		} catch (Exception e) {
			MiddlewareUtil.encapsulateException(e);
		}

		return ret;
	}

}
