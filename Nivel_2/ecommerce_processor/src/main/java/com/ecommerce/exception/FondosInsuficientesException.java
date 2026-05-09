package main.java.com.ecommerce.exception;

public class FondosInsuficientesException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public FondosInsuficientesException(String msg) {
		super(msg);
	}

}
