package main.java.com.ecommerce.payment;

import java.util.concurrent.ThreadLocalRandom;

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
		if (saldoBtc < monto) {
			throw new FondosInsuficientesException("El saldo disponible de $" + saldoBtc + " es insuficiente");
		}
		// 10% de probabilidad de falla (0 a 9)
		if (ThreadLocalRandom.current().nextInt(10) == 0) {
			throw new PagoFallidoException("Red congestionada o no hay conexión");
		}
		saldoBtc -= monto;
		System.out.println(
				"Pago de $" + monto + " procesado con éxito vía direccionWallet a la Wallet" + direccionWallet);
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
