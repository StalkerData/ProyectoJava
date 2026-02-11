package main.java.com.biblioteca.exception;

public class MaterialNoDisponibleException extends Exception {
	private static final long serialVersionUID = 1L;
	private final boolean disponible;
	private final String material;

	public MaterialNoDisponibleException(boolean disponible, String material) {
		super(String.format("El material '%s' no está disponible.", material));
		this.disponible = disponible;
		this.material = material;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public String getMaterial() {
		return material;
	}

}
