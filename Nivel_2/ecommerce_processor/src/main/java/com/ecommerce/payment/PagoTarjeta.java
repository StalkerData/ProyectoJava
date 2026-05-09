package main.java.com.ecommerce.payment;

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
		// TODO Auto-generated method stub

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
