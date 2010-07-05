package br.ufpe.cin.sd.exceptions;

@SuppressWarnings("serial")
public class ExclusaoInvalidaException extends Exception{
	
	public ExclusaoInvalidaException(){
		super();
	}
	
	public ExclusaoInvalidaException(String mensagem){
		super(mensagem);
	}
}
