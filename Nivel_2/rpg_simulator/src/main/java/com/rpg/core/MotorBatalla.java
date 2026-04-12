package main.java.com.rpg.core;

import java.util.concurrent.ThreadLocalRandom;

import main.java.com.rpg.models.Mago;
import main.java.com.rpg.models.Personaje;

public class MotorBatalla {
	private Equipo<?> equipoA;
	private Equipo<?> equipoB;

	public MotorBatalla() {
	}

	public MotorBatalla(Equipo<?> equipoA, Equipo<?> equipoB) {
		super();
		this.equipoA = equipoA;
		this.equipoB = equipoB;
	}

	public Equipo<?> getQuipoA() {
		return equipoA;
	}

	public void setQuipoA(Equipo<?> quipoA) {
		this.equipoA = quipoA;
	}

	public Equipo<?> getQuipob() {
		return equipoB;
	}

	public void setQuipob(Equipo<?> equipoB) {
		this.equipoB = equipoB;
	}

	public void pelea() {
	        Personaje atacante = equipoA.obtenerPersonajeVivoAleatorio();
	        Personaje victima = equipoB.obtenerPersonajeVivoAleatorio();

	        // Validamos por seguridad que existan personajes vivos
	        if (atacante == null || victima == null) {
	            System.out.println("No hay suficientes personajes vivos para pelear.");
	            return;
	        }

	        System.out.println("\n--- Turno de " + atacante.getNombre() + " ---");

	        // Lógica del Mago
	        if (atacante instanceof Mago) {
	            boolean decideCurar = ThreadLocalRandom.current().nextBoolean();
	            Personaje aliadoHerido = equipoA.masHerido();

	            if (decideCurar && aliadoHerido != null) {
	                System.out.println(atacante.getNombre() + " decide usar magia curativa en " + aliadoHerido.getNombre());
	                ((Mago) atacante).Curable(aliadoHerido);
	                return; 
	            }
	        }

	        System.out.println(atacante.getNombre() + " ataca a " + victima.getNombre());
	        atacante.atacar(victima);
	    }
	

}
