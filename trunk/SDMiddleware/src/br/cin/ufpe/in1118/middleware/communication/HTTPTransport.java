package br.cin.ufpe.in1118.middleware.communication;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public final class HTTPTransport extends Transport {

	private String url;
	private HttpURLConnection openConnection;
	private String currentOperation;

	HTTPTransport(String address) {
		super(false);
		this.url = address;
	}

	@Override
	public void receive() throws RemoteException {
		try{
			InputStream is = this.openConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			String line = null;
			while ( (line = br.readLine()) != null) {
				baos.write(line.getBytes());
			}
			this.getBuffer().writeBytes(baos.toByteArray());

		} catch (Exception e) {
			try {
				InputStream es = this.openConnection.getErrorStream();
				
				InputStreamReader isr = new InputStreamReader(es);
				BufferedReader br = new BufferedReader(isr);
				
				String line = null;
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				while ( (line = br.readLine()) != null) {
					baos.write(line.getBytes());
				}
				this.getBuffer().writeBytes(baos.toByteArray());
			} catch (Exception err) {
				throw new RemoteException(err); 
			}
		}
	}

	@Override
	public void send() throws RemoteException {
		try {
			if(!this.isAlive()){
				URL u = new URL(this.url);
				this.openConnection = (HttpURLConnection) u.openConnection();
				this.openConnection.setDoOutput(true);
				this.openConnection.setDoInput(true);
				this.openConnection.setRequestMethod("POST");
				this.openConnection.setRequestProperty("SOAPAction", this.currentOperation);
				this.openConnection.setRequestProperty("Expect", "100-continue");
				this.openConnection.setRequestProperty("Content-Type","text/xml; charset=utf-8");
				this.openConnection.setRequestProperty("Content-Length",String.valueOf(this.getBuffer().getLength()));
				this.openConnection.setRequestProperty("Host", this.openConnection.getURL().getHost());
			}

			OutputStream os = this.openConnection.getOutputStream();
			Buffer buffer = this.getBuffer();
			os.write(buffer.getBytes());
			os.flush();
			
			buffer.clear();
			
		} catch (IOException e) {
			throw new RemoteException(e);
		}
	}

	@Override
	public boolean isAlive() {
		return this.openConnection != null;
	}

	@Override
	public void close() {
		if(this.openConnection != null){				
			this.openConnection.disconnect();
			this.openConnection = null;
		}
	}

	public void setCurrentOperation(String currentOperation) {
		this.currentOperation = currentOperation;
	}

	public String getCurrentOperation() {
		return currentOperation;
	}
}
