package main.java.com.biblioteca.model;

public abstract class Material {
	protected String id;
	protected String titulo;
	protected int anioPublicacion;

	public Material(String id, String titulo, int anioPublicacion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anioPublicacion = anioPublicacion;
	}

	public abstract String getTipoMaterial();

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	@Override
	public String toString() {
		return "id=" + id + ", titulo=" + titulo + ", anioPublicacion=" + anioPublicacion;
	}

}
