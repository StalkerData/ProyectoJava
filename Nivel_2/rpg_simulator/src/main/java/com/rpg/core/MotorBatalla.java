package main.java.com.rpg.core;

public class MotorBatalla {
	private Equipo<?> equipoA;
	private Equipo<?> equipoB;

	public MotorBatalla() {
	}

	public MotorBatalla(Equipo<?> equipoA, Equipo<?> equipoB) {
		super();
		this.equipoA = equipoA;
		this.equipoA = equipoB;
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

}
