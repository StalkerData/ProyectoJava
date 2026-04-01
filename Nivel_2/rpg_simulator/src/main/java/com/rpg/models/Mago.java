package main.java.com.rpg.models;

import main.java.com.rpg.interfaces.Sanador;

public class Mago extends Personaje implements Sanador {

	public Mago(String nombre, int hpMax, int ataqueBase) {
		super(nombre, hpMax, hpMax, ataqueBase, true);
	}

	@Override
	void atacar(Personaje objetivo) {
		objetivo.recibirDano(ataqueBase);
	}

	@Override
	public void Curable(Personaje aliado) {
		int cantidadCura = (int) (aliado.getHpMax() * 0.1f);
		aliado.recibirCuracion(cantidadCura);
		System.out.println(aliado.getNombre() + " ha sido curado.\nHP actual: " + aliado.getHp());

	}
}
