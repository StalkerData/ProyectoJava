package main.java.com.ecommerce.payment;

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
		// TODO Auto-generated method stub

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
