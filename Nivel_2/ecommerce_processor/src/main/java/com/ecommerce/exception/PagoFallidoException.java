package main.java.com.ecommerce.exception;

public class PagoFallidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public PagoFallidoException(String msg) {
		super(msg);
	}

}
