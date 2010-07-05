package br.cin.ufpe.in1118.middleware.distribution.handlers;

import java.io.EOFException;
import java.net.SocketException;

import br.cin.ufpe.in1118.middleware.communication.Buffer;
import br.cin.ufpe.in1118.middleware.communication.Transport;
import br.cin.ufpe.in1118.middleware.distribution.message.Message;
import br.cin.ufpe.in1118.middleware.distribution.message.marshaller.GenericMarshaller;
import br.cin.ufpe.in1118.middleware.distribution.message.marshaller.MessageUnmarshaller;
import br.cin.ufpe.in1118.middleware.distribution.services.util.MiddlewareUtil;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public abstract class RequestHandler {

	private Transport transport;

	public RequestHandler(Transport transport) {
		this.transport = transport;
	}
	
	public void send (Message message) throws RemoteException {
		try {
			byte[] bytes = GenericMarshaller.getInstance().marshall(message);
			Buffer buffer = this.getTransport().getBuffer();
			buffer.writeBytes(bytes);
			this.getTransport().send();
		} catch (Exception e) {
			getTransport().close();
			MiddlewareUtil.encapsulateException(e);
		}
	}

	public Message receive() throws RemoteException {
		Message message = null;

		while (true) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {

			}
			
			try {
				this.getTransport().receive();

				Buffer buffer = getTransport().getBuffer();
				byte[] bytes = buffer.readBytes(buffer.getLength());

				message = MessageUnmarshaller.getInstance().unmarshal(bytes);
				return message;
			} catch (Exception e) {
				Class<?> cl = e.getCause().getClass();
				if (cl.equals(EOFException.class) || cl.equals(SocketException.class)) {
					continue;
				}
				getTransport().close();
				MiddlewareUtil.encapsulateException(e);
			}
		}

	}
	
	protected Transport getTransport() {
		return transport;
	}
}
