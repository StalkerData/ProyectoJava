package main.java.com.rpg.models;

public abstract class Personaje {
	protected String nombre;
	protected int hp;
	protected int hpMax;
	int ataqueBase;
	boolean estaVivo;

	public Personaje(String nombre, int hp, int hpMax, int ataqueBase, boolean estaVivo) {
		super();
		this.nombre = nombre;
		this.hp = hp;
		this.hpMax = hpMax;
		this.ataqueBase = ataqueBase;
		this.estaVivo = estaVivo;
	}

	public void recibirDano(int cantidad) {
		hp = hp - cantidad;
		if (hp <= 0) {
			estaVivo = false;
			hp = 0;
		}
	}

	public void recibirCuracion(int cantidad) {
		if (this.estaVivo) {
			this.hp += cantidad;
			if (this.hp > this.hpMax) {
				this.hp = this.hpMax;
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getHp() {
		return hp;
	}

	public int getHpMax() {
		return hpMax;
	}

	public int getAtaqueBase() {
		return ataqueBase;
	}

	public boolean isEstaVivo() {
		return estaVivo;
	}

	public abstract void atacar(Personaje objetivo);

}
