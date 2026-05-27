package main.java.com.ecommerce.service;

import main.java.com.ecommerce.model.Categoria;
import main.java.com.ecommerce.model.Pedido;
import main.java.com.ecommerce.model.Producto;

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

}
