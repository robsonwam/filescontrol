package br.cin.ufpe.in1118.middleware.communication;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Buffer implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Byte> bytesArrayList;

	Buffer() {
		this.bytesArrayList = new ArrayList<Byte>();
	}

	public byte[] getBytes() {
		byte[] ret = new byte[this.bytesArrayList.size()];
		int i = 0;
		for (Byte byte1 : this.bytesArrayList) {
			ret[i++] = byte1;
		}

		return ret;
	}

	public int getLength() {
		return this.bytesArrayList.size();
	}

	@SuppressWarnings("unchecked")
	public byte[] readBytes(int length) throws IOException {
		synchronized (this) {
			byte[] ret = new byte[length];
			
			if (length >= 0) {
				if (length <= this.getLength()) {
					List<Byte> subList = this.bytesArrayList.subList(0, length);
					
					for (int i = 0; i < subList.size(); i++) {
						ret[i] = subList.get(i);
						
					}
					
					List<Byte> endList = Collections.EMPTY_LIST;
					
					if(length < this.bytesArrayList.size()){
						endList = this.bytesArrayList.subList(length + 1, this.bytesArrayList.size());
					}
					
					this.bytesArrayList.clear();
					this.bytesArrayList.addAll(endList);
				} else {
					throw new IOException("Nao existe tantos bytes no buffer");
				}
			} else {
				throw new IOException(
				"Nao se pode pedir um numero negativo de bytes do buffer");
			}
			
			return ret;
		}
	}

	public byte readByte() throws IOException {
		return this.readBytes(1)[0];
	}

	public int writeBytes(byte[] bytes) {
		synchronized (this) {
			int ret = 0;
			for (byte b : bytes) {
				this.bytesArrayList.add(b);
			}
			ret = bytes.length;
			return ret;
		}		
	}

	public int writeByte(byte bytee) {
		return this.writeBytes(new byte[] { bytee });
	}

	public void clear() {
		this.bytesArrayList.clear();
	}
}
