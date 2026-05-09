package main.java.com.ecommerce.payment;

import main.java.com.ecommerce.exception.FondosInsuficientesException;
import main.java.com.ecommerce.exception.PagoFallidoException;

public interface MetodoPago {
	void procesarPago(double monto) throws PagoFallidoException, FondosInsuficientesException;
}
