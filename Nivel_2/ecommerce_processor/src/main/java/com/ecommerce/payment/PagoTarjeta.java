package main.java.com.ecommerce.payment;

import java.util.concurrent.ThreadLocalRandom;

import main.java.com.ecommerce.exception.FondosInsuficientesException;
import main.java.com.ecommerce.exception.PagoFallidoException;

public class PagoTarjeta implements MetodoPago {
	private String numeroTarjeta;
	private double saldoDisponible;

	public PagoTarjeta() {
		super();
	}

	public PagoTarjeta(String numeroTarjeta, double saldoDisponible) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.saldoDisponible = saldoDisponible;
	}

	@Override
	public void procesarPago(double monto) throws PagoFallidoException, FondosInsuficientesException {
		if (saldoDisponible < monto) {
			throw new FondosInsuficientesException("El saldo disponible de $" + saldoDisponible + " es insuficiente");
		}
		// 10% de probabilidad de falla (0 a 9)
		if (ThreadLocalRandom.current().nextInt(10) == 0) {
			throw new PagoFallidoException("Red congestionada o no hay conexión");
		}
		saldoDisponible -= monto;
		System.out.println("Pago de $" + monto + " procesado con éxito vía Tarjeta");
	}

	// *************************
	// GETTER & SETTER
	// *************************

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public double getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

}
