package main.java.com.biblioteca.model;

import main.java.com.biblioteca.exception.MaterialNoDisponibleException;
import main.java.com.biblioteca.interfaces.Prestable;

public class Audiovisual extends Material implements Prestable {
	private String formato;
	private int duracionMinutos;
	private boolean disponible;

	public Audiovisual(String id, String titulo, int anioPublicacion, String formato, int duracionMinutos) {
		super(id, titulo, anioPublicacion);
		this.formato = formato;
		this.duracionMinutos = duracionMinutos;
		this.disponible = true;
	}

	public String getFormato() {
		return formato;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
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
		return "Audiovisual";
	}

	@Override
	public String toString() {
		return "Audiovisual [" + super.toString() + ", formato=" + formato + ", duracionMinutos=" + duracionMinutos
				+ ", disponible=" + disponible + "]";
	}

}
