package main.java.com.ecommerce.payment;

import java.util.concurrent.ThreadLocalRandom;

import main.java.com.ecommerce.exception.FondosInsuficientesException;
import main.java.com.ecommerce.exception.PagoFallidoException;

public class PagoPayPal implements MetodoPago {
	private String correo;
	private double saldoCuenta;

	public PagoPayPal() {
		super();
	}

	public PagoPayPal(String correo, double saldoCuenta) {
		super();
		this.correo = correo;
		this.saldoCuenta = saldoCuenta;
	}

	@Override
	public void procesarPago(double monto) throws PagoFallidoException, FondosInsuficientesException {
		if (saldoCuenta < monto) {
			throw new FondosInsuficientesException("El saldo disponible de $" + saldoCuenta + " es insuficiente");
		}
		// 10% de probabilidad de falla (0 a 9)
		if (ThreadLocalRandom.current().nextInt(10) == 0) {
			throw new PagoFallidoException("Red congestionada o no hay conexión");
		}
		saldoCuenta -= monto;
		System.out.println("Pago de $" + monto + " procesado con éxito vía PayPal al correo" + correo);
	}

	// *************************
	// GETTER & SETTER
	// *************************

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public double getSaldoCuenta() {
		return saldoCuenta;
	}

	public void setSaldoCuenta(double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

}
