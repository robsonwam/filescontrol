package br.cin.ufpe.in1118.middleware.distribution.services.naming;

import br.cin.ufpe.in1118.middleware.distribution.services.JavaReference;

public class NamingService {

	public static Naming getNamingInstance(String host, int port){
		JavaReference reference = new JavaReference(host, port, "namingService", Naming.class.getCanonicalName());
		return new Naming_Stub(reference);
	}
	
}
