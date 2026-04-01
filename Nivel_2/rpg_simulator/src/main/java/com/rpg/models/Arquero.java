package main.java.com.rpg.models;

import java.util.concurrent.ThreadLocalRandom;

public class Arquero extends Personaje {

	public Arquero(String nombre, int hpMax, int ataqueBase) {
		super(nombre, hpMax, hpMax, ataqueBase, true);
	}

	@Override
	void atacar(Personaje objetivo) {
		int probabilidad = ThreadLocalRandom.current().nextInt(1, 101);

		if (probabilidad <= 25) {
			objetivo.recibirDano(this.ataqueBase * 2);
			System.out.println(this.nombre + " asesta un GOLPE CRÍTICO!");
		} else {
			objetivo.recibirDano(this.ataqueBase);
		}

	}

}
