package main.java.com.rpg.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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
		this.miembros = new ArrayList<>(miembros);

	}

	public void agregarMiembro(T personaje) throws LimiteEquipoSuperado {
		if (miembros.size() >= limite) {
			throw new LimiteEquipoSuperado("No se puede agregar este personaje, supera el límite del Party.");
		}
		miembros.add(personaje);
	}

	public boolean tieneVivos() {
		return miembros.stream().anyMatch(Personaje::isEstaVivo);
	}

	public T obtenerPersonajeVivoAleatorio() {
		List<T> vivos = miembros.stream().filter(Personaje::isEstaVivo).collect(Collectors.toList());
		if (vivos.isEmpty()) {
			return null;
		}

		int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, vivos.size());
		return vivos.get(indiceAleatorio);
	}

	public T masHerido() {
		T masHerido = null;
		int menorHp = Integer.MAX_VALUE;

		for (T per : miembros) {
			if (per.getHp() == per.getHpMax())
				continue;
			if (per.isEstaVivo() && per.getHp() < menorHp) {
				menorHp = per.getHp();
				masHerido = per;
			}
		}
		return masHerido;
	}

	public int getLimite() {
		return limite;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public List<T> getMiembros() {
		return List.copyOf(miembros);
	}

}
