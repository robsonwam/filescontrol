package br.cin.ufpe.in1118.middleware.communication;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public final class TCPTransport extends Transport {

	private static final int PACOTE_LENGTH = 1024;

	private Socket socket;

	private static ServerSocket serverSocket;

	private int port;

	private String host;

	TCPTransport(String address, int port, boolean isServer) {
		super(isServer);
		this.port = port;
		this.host = address;
	}

	@Override
	public void receive() throws RemoteException {
		try {
			if (this.socket != null && this.socket.isClosed()) {
				this.socket = null;
			}

			if (this.socket == null && this.isServer()) {
				if (serverSocket == null) {
					serverSocket = new ServerSocket(this.port);
				}
				this.socket = serverSocket.accept();
			}

			while (this.socket == null) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			ObjectInputStream bis = new ObjectInputStream(this.socket
					.getInputStream());

			int pacotes = bis.readInt();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			for (int i = 0; i < pacotes; i++) {
				byte[] bytes = (byte[]) bis.readObject();

				baos.write(bytes);
			}

			byte[] byteArray = baos.toByteArray();

			this.getBuffer().writeBytes(byteArray);

		} catch (ClassNotFoundException e) {
			throw new RemoteException("Objeto Inesperado chegou pelo socket", e);
		} catch (IOException e) {
			try {
				this.socket.close();
			} catch (IOException e1) {
				//TODO Para não sujar a tela, não imprime nada =)
			}
			throw new RemoteException(e);
		}
	}

	@Override
	public void send() throws RemoteException {
		try {
			if (this.socket == null) {
				this.socket = new Socket(this.host, port);
			}

			ObjectOutputStream bos = new ObjectOutputStream(this.socket
					.getOutputStream());

			byte[] bytes = this.getBuffer().getBytes();

			int pacotes = (int) Math
			.ceil(bytes.length / (double) PACOTE_LENGTH);

			bos.writeInt(pacotes);

			for (int i = 0; i < pacotes; i++) {

				int restante = bytes.length - i * PACOTE_LENGTH;
				int tamanhoPacote = (restante < PACOTE_LENGTH) ? restante
						: PACOTE_LENGTH;

				byte[] bytesEnviados = new byte[tamanhoPacote];
				System.arraycopy(bytes, i * PACOTE_LENGTH, bytesEnviados, 0,
						tamanhoPacote);

				bos.writeObject(bytesEnviados);
			}

			bos.flush();

			this.getBuffer().clear();
		} catch (UnknownHostException e) {
			throw new RemoteException(e);
		} catch (IOException e) {
			this.close();
			throw new RemoteException(e);
		}
	}

	@Override
	public boolean isAlive() {
		return !this.socket.isClosed();
	}

	@Override
	public void close() {
		try {
			if(this.socket != null){				
				this.socket.close();
				this.socket = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
