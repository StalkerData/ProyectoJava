package main.java.com.rpg.models;

public class Guerrero extends Personaje {

	public Guerrero(String nombre,int hpMax, int ataqueBase) {
		int vida=(int) ((float)hpMax*1.2f);
		super(nombre, vida, vida, ataqueBase, true);
	}

	@Override
	public void atacar(Personaje objetivo) {
		float golpe = this.ataqueBase * 1.2f;
		objetivo.recibirDano((int) (golpe));
	}

}
