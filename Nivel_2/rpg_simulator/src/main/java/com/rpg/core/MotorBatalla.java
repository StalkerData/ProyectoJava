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

	private void turnoAtaque(Personaje atacante, Personaje victima,Equipo<?> equipoAtacante) {
		System.out.println("\n--- Turno de " + atacante.getNombre() + " ---");
		// Lógica del Mago
		if (atacante instanceof Mago) {
			boolean decideCurar = ThreadLocalRandom.current().nextBoolean();
			Personaje aliadoHerido = equipoAtacante.masHerido();

			if (decideCurar && aliadoHerido != null) {
				System.out.println(atacante.getNombre() + " decide usar magia curativa en " + aliadoHerido.getNombre());
				((Mago) atacante).Curable(aliadoHerido);
				return;
			}
		}

		System.out.println(atacante.getNombre() + " ataca a " + victima.getNombre());
		atacante.atacar(victima);
		
	}

	
	public void batalla() {
		boolean turnoEquipoA = true; 

		System.out.println("⚔️ ¡COMIENZA LA BATALLA! ⚔️");

		while (equipoA.tieneVivos() && equipoB.tieneVivos()) {
			
			Equipo<?> equipoAtacante = turnoEquipoA ? equipoA : equipoB;
			Equipo<?> equipoDefensor = turnoEquipoA ? equipoB : equipoA;

			Personaje atacante = equipoAtacante.obtenerPersonajeVivoAleatorio();
			Personaje victima = equipoDefensor.obtenerPersonajeVivoAleatorio();

			turnoAtaque(atacante, victima, equipoAtacante);

			turnoEquipoA = !turnoEquipoA; 
		}

		Equipo<?> ganador = equipoA.tieneVivos() ? equipoA : equipoB;
		System.out.println("\n🏆 El Equipo ganador es: " + ganador.getNombreEquipo() + " 🏆");
	}

}
