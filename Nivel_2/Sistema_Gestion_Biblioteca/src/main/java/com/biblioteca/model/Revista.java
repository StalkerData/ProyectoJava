package main.java.com.biblioteca.model;

public class Revista extends Material {
	private int numeroEdicion;

	public Revista(String id, String titulo, int anioPublicacion, int numeroEdicion) {
		super(id, titulo, anioPublicacion);
		this.numeroEdicion = numeroEdicion;
	}

	public int getNumeroEdicion() {
		return numeroEdicion;
	}

	@Override
	public String getTipoMaterial() {
		return "Revista";
	}

	@Override
	public String toString() {
		return super.toString() + "\nnumeroEdicion: " + numeroEdicion;
	}

}
