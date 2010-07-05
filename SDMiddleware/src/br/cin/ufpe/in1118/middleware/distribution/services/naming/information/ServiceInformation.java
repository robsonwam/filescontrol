package br.cin.ufpe.in1118.middleware.distribution.services.naming.information;

import java.io.Serializable;

import br.cin.ufpe.in1118.middleware.distribution.services.ObjectReference;

public class ServiceInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String serviceName;
	private ObjectReference objectReference;
	private Integer pingTime;
	
	public ServiceInformation(String serviceName, ObjectReference objectReference, Integer pingTime) {
		this.serviceName = serviceName;
		this.objectReference = objectReference;
		this.pingTime = pingTime;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	public ObjectReference getObjectReference() {
		return objectReference;
	}
	
	public Integer getPingTime() {
		return pingTime;
	}

}
