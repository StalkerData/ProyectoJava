package main.java.com.biblioteca.exception;

public class IdDuplicadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdDuplicadoException(String id) {
		super(String.format("El ID: %s ya se encuentra.", id));
	}
}
