package main.java.com.rpg.core;

import java.util.ArrayList;
import java.util.List;

import main.java.com.rpg.exception.LimiteEquipoSuperado;
import main.java.com.rpg.models.Personaje;

public class Equipo<T extends Personaje> {
	private final int limite = 3;
	private String nombreEquipo;
	private List<T> miembros;

	public Equipo(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.miembros = new ArrayList<T>();
	}

	public Equipo(String nombreEquipo, List<T> miembros) throws LimiteEquipoSuperado {
		super();
		this.nombreEquipo = nombreEquipo;

		if (miembros.size() > limite) {
			throw new LimiteEquipoSuperado("El equipo supera el tamano permitido del Party.");
		}
		this.miembros = miembros;

	}

	public void agregarMiembro(T personaje) throws LimiteEquipoSuperado {
		if (miembros.size() > limite) {
			throw new LimiteEquipoSuperado("No e puede agregar este personaje, supera el limite del Party.");
		}
		miembros.add(personaje);
	}

	public boolean tieneVivos() {
		for (T t : miembros) {
			if (t.isEstaVivo() == true)
				return true;
		}
		return false;
	}

	public T obtenerPersonajeVivoAleatorio() {
		return null;

	}

	public int getLimite() {
		return limite;
	}

	public String getNombreEquipo() {

		return nombreEquipo;
	}

	public List<T> getMiembros() {
		return List.copyOf(miembros);
		// miembros.stream().collect(Collectors.toList());
		// new ArrayList<>(miembros);
		// new ArrayList<>().addAll(miembros);
	}

}
