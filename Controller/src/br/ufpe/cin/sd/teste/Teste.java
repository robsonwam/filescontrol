package br.ufpe.cin.sd.teste;

import br.ufpe.cin.sd.controller.Facade;
import br.ufpe.cin.sd.exceptions.OperacaoInvalidaException;
import br.ufpe.cin.sd.model.business.entities.Node;
import br.ufpe.cin.sd.model.business.entities.NodePK;

public class Teste {
	
	public static void main(String[] args) throws OperacaoInvalidaException {
		
		Node node = new Node();
		NodePK pk = new NodePK();
		pk.setIp("localhost");
		pk.setPort(80);
		node.setId(pk);
		node.setNumRequisicoes(0);
		Facade facade = new Facade();
		facade.inserir(node);
	}

}
