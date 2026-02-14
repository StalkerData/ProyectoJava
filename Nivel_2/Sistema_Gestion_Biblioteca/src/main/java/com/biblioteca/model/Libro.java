package main.java.com.biblioteca.model;

import main.java.com.biblioteca.exception.MaterialNoDisponibleException;
import main.java.com.biblioteca.interfaces.Prestable;

public class Libro extends Material implements Prestable {
	private String autor;
	private String isbn;
	private boolean disponible;

	public Libro(String id, String titulo, int anioPublicacion, String autor, String isbn) {
		super(id, titulo, anioPublicacion);
		this.autor = autor;
		this.isbn = isbn;
		this.disponible = true;
	}

	public String getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public boolean isDisponible() {
		return disponible;
	}

	@Override
	public void prestar() throws Exception {
		if (disponible)
			this.disponible = false;
		else {
			throw new MaterialNoDisponibleException(
					String.format("Este material: %s, no se puede prestar.", this.getTipoMaterial()));
		}
	}

	@Override
	public void devolver() {
		this.disponible = true;
	}

	@Override
	public String getTipoMaterial() {
		return "Libro";
	}

	@Override
	public String toString() {
		return "Libro [" + super.toString() + ", autor=" + autor + ", isbn=" + isbn + ", disponible=" + disponible
				+ "]";
	}

}
