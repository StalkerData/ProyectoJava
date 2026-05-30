package main.java.com.ecommerce.service;

import java.util.Comparator;
import java.util.List;

import main.java.com.ecommerce.exception.FondosInsuficientesException;
import main.java.com.ecommerce.exception.PagoFallidoException;
import main.java.com.ecommerce.model.Categoria;
import main.java.com.ecommerce.model.Pedido;
import main.java.com.ecommerce.model.Producto;
import main.java.com.ecommerce.payment.MetodoPago;

public class ProcesadorDePedidos {

	double calcularTotalSinImpuestos(Pedido pedido) {
		return pedido.getCarrito().stream().mapToDouble(Producto::precio).sum();
	}

	private double factorImpuesto(Categoria categoria) {
		return switch (categoria) {
		case ELECTRONICA -> 1.19;
		case ROPA -> 1.12;
		case ALIMENTOS -> 1.05;
		};
	}

	public double calcularTotalConImpuestos(Pedido pedido) {
		return pedido.getCarrito().stream()
				.mapToDouble(producto -> producto.precio() * factorImpuesto(producto.categoria())).sum();
	}

	List<Producto> filtrarPorCategoria(Pedido pedido, Categoria categoria) {
		return pedido.getCarrito().stream().filter(producto -> producto.categoria().equals(categoria)).toList();

	}

	void ordenarProductosPorPrecio(Pedido pedido, Comparator<Producto> comparador) {
		List<Producto> listaOrdenada = pedido.getCarrito().stream().sorted(comparador).toList();
		pedido.setCarrito(listaOrdenada);
	}

	void procesar(Pedido pedido, MetodoPago metodoPago) throws Exception {
		double total = calcularTotalConImpuestos(pedido);
		try {
			metodoPago.procesarPago(total);
			System.out.println("Pago procesado exitosamente. Total: " + total);
		} catch (FondosInsuficientesException e) {
			System.err.println("Fondos insuficientes para el este pedido");
			throw e;
		} catch (PagoFallidoException e) {
			System.err.println("Error al procesar el pago");
			throw e;
		}
	}

}
