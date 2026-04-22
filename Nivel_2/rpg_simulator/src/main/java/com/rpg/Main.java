package main.java.com.rpg;

import java.util.ArrayList;
import java.util.List;

import main.java.com.rpg.core.Equipo;
import main.java.com.rpg.core.MotorBatalla;
import main.java.com.rpg.exception.LimiteEquipoSuperado;
import main.java.com.rpg.models.Arquero;
import main.java.com.rpg.models.Guerrero;
import main.java.com.rpg.models.Mago;
import main.java.com.rpg.models.Personaje;

public class Main {

	public static void main(String[] args) {
		List<Personaje>equipo1;
		List<Personaje>equipo2;
		equipo1=new ArrayList<Personaje>();
		equipo1.add(new Arquero("legolas", 100, 10));
		equipo1.add(new Guerrero("conal", 120, 12));
		equipo1.add(new Mago("merlin", 80, 8));
		equipo2=new ArrayList<Personaje>();
		equipo2.add(new Arquero("robin", 100, 10));
		equipo2.add(new Guerrero("sanson", 120, 12));
		equipo2.add(new Mago("scarles", 80, 8));
		System.out.println("Comienza de Juego");
		Equipo<Personaje> eq1 = null;
		Equipo<Personaje> eq2 = null;
		try {
			eq1= new Equipo<>("los magnificos",equipo1);
			eq2= new Equipo<>("los locos",equipo2);
		} catch (LimiteEquipoSuperado e) {
			// TODO Auto-generated catch block
			System.err.println(e.toString());
		}
		MotorBatalla gameBatalla= new MotorBatalla(eq1,eq2);
		gameBatalla.batalla();

		System.out.println("Fin del Juego");
	}

}
