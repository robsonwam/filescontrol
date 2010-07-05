package br.cin.ufpe.in1118.middleware.distribution.message;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;

import br.cin.ufpe.in1118.middleware.exceptions.RemoteException;

public abstract class SOAPFactory {
	
	public static final String TEMPLATE_XML_DECLARATION = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
	public static final String TEMPLATE_HEADER_ENV = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\""
			+ " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
			+ " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">";
	public static final String TEMPLATE_HEADER_BODY = "<soap:Body>";
	public static final String TEMPLATE_TAIL_BODY = "</soap:Body>";
	public static final String TEMPLATE_TAIL_ENV = "</soap:Envelope>";

	public abstract String toSOAP(String operation, Object... parameters);

	public abstract Object fromSOAP(String operation, String soapMessage) throws RemoteException;

	protected static Element createRootElement(String soapMessage) throws DocumentException {
		Document doc = DocumentHelper.parseText(soapMessage);
		List<?> allNodes = doc.selectNodes("//*");
		Element rootElement = doc.getRootElement();
		for (Object ob1 : allNodes) {
			if (ob1 instanceof Element) {
				List<?> declaredNamespaces = ((Element) ob1).declaredNamespaces();
				for (Object ob2 : declaredNamespaces) {
					if (ob2 instanceof Namespace) {
						Namespace ns = (Namespace) ob2;
						rootElement.addNamespace(ns.getPrefix(), ns.getURI());
					}
				}
			}
		}
		return rootElement;
	}

	public String getOperationName(String operation) {
		return "urn:" + operation;
	}

}
