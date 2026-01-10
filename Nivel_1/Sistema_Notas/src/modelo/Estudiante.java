package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
	private String nombre;
	private String id;
	private List<Float> lista_notas;

	public Estudiante(String identificador, String nombre) {
		this.id = identificador;
		this.nombre = nombre;
		this.lista_notas = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return id;
	}

	public void setIdentificador(String identificador) {
		this.id = identificador;
	}

	public List<Float> getLista_notas() {
		return lista_notas;
	}

	public void setLista_notas(List<Float> lista_notas) {
		this.lista_notas = lista_notas;
	}

	@Override
	public String toString() {
		String lista = lista_notas == null ? "[]" : lista_notas.toString();
		return "Estudiante:\n- identificador:" + id + "\n- nombre: " + nombre + "\n- lista_notas: " + lista;
	}

}
