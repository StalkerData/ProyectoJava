package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
	private String nombre;
	private String identificador;
	private List<Float> lista_notas;

	public Estudiante(String identificador, String nombre) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.lista_notas = new ArrayList<Float>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public List<Float> getLista_notas() {
		return lista_notas;
	}

	public void setLista_notas(List<Float> lista_notas) {
		this.lista_notas = lista_notas;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + "\nidentificador:" + identificador + "\nlista_notas: " + lista_notas.toString();
	}

}
