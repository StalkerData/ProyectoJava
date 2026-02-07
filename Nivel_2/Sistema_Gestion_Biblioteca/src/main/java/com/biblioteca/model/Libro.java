package biblioteca.model;

import biblioteca.interfaces.Prestable;

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
	public void prestar() {
		if (disponible)
			this.disponible = false;
		else {
			// prototipo de exepcion, todavia no imprementado
			System.out.println("Error");
			return;
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
		return super.toString() + "\nautor: " + autor + "\nisbn: " + isbn + "\ndisponible: " + disponible;
	}

}
