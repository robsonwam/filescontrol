package br.cin.ufpe.in1118.middleware.distribution.services.naming.information;

import java.io.Serializable;

public class LogInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String message;
	private Long timestamp;
	
	public LogInformation(String message) {
		this.message = message;
		this.timestamp = System.currentTimeMillis();
	}
	
	public String getMessage() {
		return message;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}

}
