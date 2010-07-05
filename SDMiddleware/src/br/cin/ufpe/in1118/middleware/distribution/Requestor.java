package br.cin.ufpe.in1118.middleware.distribution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import br.cin.ufpe.in1118.middleware.communication.HTTPTransport;
import br.cin.ufpe.in1118.middleware.communication.Transport;
import br.cin.ufpe.in1118.middleware.distribution.handlers.ClientRequestHandler;
import br.cin.ufpe.in1118.middleware.distribution.message.HTTPMessage;
import br.cin.ufpe.in1118.middleware.distribution.message.JavaMessage;
import br.cin.ufpe.in1118.middleware.distribution.message.Message;
import br.cin.ufpe.in1118.middleware.distribution.message.SOAPFactory;
import br.cin.ufpe.in1118.middleware.distribution.services.util.MiddlewareUtil;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class Requestor {

	private ClientRequestHandler clientHandler;
	private Random random = new Random();
	private Transport _localRefTrans = null;

	public Requestor(Transport transport) {
		this.clientHandler = new ClientRequestHandler(transport);
		this._localRefTrans = transport;
	}

	public Object invokeJava(Object objectId, String operation, Object... parameters) throws RemoteException {
		try {
			Object ret = null;

			JavaMessage message = new JavaMessage(objectId, operation, new ArrayList<Object>(Arrays.asList(parameters)), null);

			long messageId = random.nextLong();
			
			message.setMessageId(messageId);
			
			JavaMessage msg = (JavaMessage) _invoke(message);
			
			ret = msg.getReturn();
			
			if (msg.hasException()) {
				MiddlewareUtil.encapsulateException((Exception) ret);
			}
			
			return ret;
		} catch (Exception e) {
			MiddlewareUtil.encapsulateException(e);
		} finally {
			this.clientHandler.close();
		}
		return null;
	}
	
	private Message _invoke(Message message) throws RemoteException {
		try {
			this.clientHandler.send(message);
			Message msg = this.clientHandler.receive();
			
			return msg;
		} catch (Exception e) {
			MiddlewareUtil.encapsulateException(e);
		} finally {
			this.clientHandler.close();
		}
		return null;
	}
	
	public Object invokeWS(SOAPFactory wsdlAddress, String operation, Object... parameters) throws RemoteException {
		HTTPMessage httpMessage = new HTTPMessage();
		httpMessage.setBody(wsdlAddress.toSOAP(operation, parameters));
		
		if (this._localRefTrans instanceof HTTPTransport) {
			HTTPTransport trans = (HTTPTransport) this._localRefTrans;
			trans.setCurrentOperation(wsdlAddress.getOperationName(operation));
		}
		
		HTTPMessage response = (HTTPMessage) _invoke(httpMessage);
		return wsdlAddress.fromSOAP(operation, response.getBody());
	}

}
