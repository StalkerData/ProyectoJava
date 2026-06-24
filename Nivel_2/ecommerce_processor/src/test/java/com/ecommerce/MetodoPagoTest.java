package test.java.com.ecommerce;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.ecommerce.exception.FondosInsuficientesException;
import main.java.com.ecommerce.exception.PagoFallidoException;
import main.java.com.ecommerce.model.Categoria;
import main.java.com.ecommerce.model.Pedido;
import main.java.com.ecommerce.model.Producto;
import main.java.com.ecommerce.payment.*;
import main.java.com.ecommerce.service.ProcesadorDePedidos;

class MetodoPagoTest {
	private PagoCripto cripto;
	private PagoPayPal payPal;
	private PagoTarjeta tarjeta;
	private ProcesadorDePedidos servicioDePedidos;

	@BeforeEach
	void setUp() throws Exception {
		cripto = new PagoCripto("323414fsaf", 1000.0);
		payPal = new PagoPayPal("test@email.com", 50.0);
		tarjeta = new PagoTarjeta("123574", 500.0);
		servicioDePedidos = new ProcesadorDePedidos();
	}

	@Test
	void testPagoExitoso() throws FondosInsuficientesException, PagoFallidoException {
		tarjeta.procesarPago(150.0);
		double resto = tarjeta.getSaldoDisponible();
		assertEquals(350.0, resto);
	}

	@Test
	void testFondosInsuficientes() {
		assertThrows(FondosInsuficientesException.class, () -> {
			payPal.procesarPago(100.0);
		});
	}

	@Test
	void testIntegracion() {
		List<Producto> productoList = List.of(new Producto("001", "Laptop", 150.0, Categoria.ELECTRONICA),
				new Producto("002", "Camiseta", 50.0, Categoria.ROPA),
				new Producto("003", "Pan", 20.0, Categoria.ALIMENTOS));
		Pedido pedido = new Pedido(productoList);

		assertDoesNotThrow(() -> {
			servicioDePedidos.procesar(pedido, cripto);
		});

	}

}
