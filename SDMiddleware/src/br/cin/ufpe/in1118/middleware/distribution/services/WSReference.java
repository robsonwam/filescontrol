package br.cin.ufpe.in1118.middleware.distribution.services;

import java.net.MalformedURLException;
import java.net.URL;


public class WSReference extends ObjectReference {

	private static final long serialVersionUID = 1L;

	private String url;

	public WSReference(String url, String interfaceName) {
		super(interfaceName);
		this.url = url;
	}

	public String getURL() {
		return this.url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ret = false;

		if (obj instanceof WSReference) {
			WSReference reference = (WSReference) obj;
			if (reference.url.equalsIgnoreCase(this.url)
					&& reference.getInterfaceName().equals(this.getInterfaceName())) {
				ret = true;
			}
		}

		return ret;
	}
	
	@Override
	public String toString() {
		return String.format("WSReference[url=\"%s\"]", url);
	}

	@Override
	public String getHost() {
		try {
			URL u = new URL(this.url);
			return u.getHost();
		} catch (MalformedURLException e) {
			return null;
		}
	}

}
