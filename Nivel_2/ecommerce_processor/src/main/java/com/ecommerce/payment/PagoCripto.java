package main.java.com.ecommerce.payment;

import main.java.com.ecommerce.exception.FondosInsuficientesException;
import main.java.com.ecommerce.exception.PagoFallidoException;

public class PagoCripto implements MetodoPago {

	private String direccionWallet;
	private double saldoBtc;

	public PagoCripto() {
		super();

	}

	public PagoCripto(String direccionWallet, double saldoBtc) {
		super();
		this.direccionWallet = direccionWallet;
		this.saldoBtc = saldoBtc;
	}

	@Override
	public void procesarPago(double monto) throws PagoFallidoException, FondosInsuficientesException {
		// TODO Auto-generated method stub

	}

	// *************************
	// GETTER & SETTER
	// *************************

	public String getDireccionWallet() {
		return direccionWallet;
	}

	public void setDireccionWallet(String direccionWallet) {
		this.direccionWallet = direccionWallet;
	}

	public double getSaldoBtc() {
		return saldoBtc;
	}

	public void setSaldoBtc(double saldoBtc) {
		this.saldoBtc = saldoBtc;
	}

}
