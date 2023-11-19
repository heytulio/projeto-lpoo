package model.entities.exceptions;

public class LimitedSignatureException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public LimitedSignatureException(String msg) {
		super(msg);
	}
	
}
