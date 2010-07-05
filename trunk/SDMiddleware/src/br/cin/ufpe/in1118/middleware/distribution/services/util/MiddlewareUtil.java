package br.cin.ufpe.in1118.middleware.distribution.services.util;

import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import br.cin.ufpe.in1118.middleware.distribution.services.JavaReference;
import br.cin.ufpe.in1118.middleware.distribution.services.ObjectReference;
import br.cin.ufpe.in1118.middleware.distribution.services.WSReference;
import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public class MiddlewareUtil {

	public static boolean isON(ObjectReference objectReference) {
		String host = objectReference.getHost();
		int port = -1;
		
		if (objectReference instanceof JavaReference) {
			JavaReference jr = (JavaReference) objectReference;
			port = jr.getPort();
		}
		
		if (objectReference instanceof WSReference) {
			WSReference ws = (WSReference) objectReference;
			String url = ws.getURL();
			try {
				URL u = new URL(url);
				port = u.getPort();
				if (port < 0) {
					port = 80;
				}
			} catch (MalformedURLException e) {
				return false;
			}
		}

		try {
			Socket s = new Socket(host,port);
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void encapsulateException(Exception e) throws RemoteException {
		if (e instanceof RemoteException) {
			throw (RemoteException) e;
		}
		throw new RemoteException(e);
	}

}
