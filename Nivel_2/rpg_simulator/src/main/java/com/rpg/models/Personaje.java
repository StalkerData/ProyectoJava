package main.java.com.rpg.models;

public abstract class Personaje {
	protected String nombre;
	protected int hp;
	protected int hpMax;
	int ataqueBase;
	boolean estaVivo;

	public void recibirDano(int cantidad) {
		hp = hp - cantidad;
		if (hp <= 0) {
			estaVivo = false;
			hp = 0;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getHp() {
		return hp;
	}

	public boolean isEstaVivo() {
		return estaVivo;
	}

	abstract void atacar(Personaje objetivo);

}
