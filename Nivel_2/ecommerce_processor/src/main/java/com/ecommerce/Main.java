package main.java.com.ecommerce;

import java.util.Comparator;
import java.util.List;

import main.java.com.ecommerce.exception.FondosInsuficientesException;
import main.java.com.ecommerce.exception.PagoFallidoException;
import main.java.com.ecommerce.model.Categoria;
import main.java.com.ecommerce.model.Pedido;
import main.java.com.ecommerce.model.Producto;
import main.java.com.ecommerce.payment.PagoCripto;
import main.java.com.ecommerce.service.ProcesadorDePedidos;

public class Main {
	public static void main(String[] args) {
		Producto p1 = new Producto("001", "Laptop", 999.99, Categoria.ELECTRONICA);
		Producto p2 = new Producto("001", "Teclado", 20.99, Categoria.ELECTRONICA);
		Producto p3 = new Producto("002", "Vestido", 120.0, Categoria.ROPA);
		Producto p4 = new Producto("003", "Manzana", 10.0, Categoria.ALIMENTOS);

		List<Producto> productoList = List.of(p1, p2, p3, p4);

		Pedido pedido1 = new Pedido(productoList);

		System.out.println(ProcesadorDePedidos.calcularTotalSinImpuestos(pedido1));
		System.out.println(ProcesadorDePedidos.calcularTotalConImpuestos(pedido1));

		for (Producto producto : ProcesadorDePedidos.filtrarPorCategoria(pedido1, Categoria.ELECTRONICA)) {
			System.out.println(producto);
		}
		
		System.out.println("\nSin Ordenar");
		for (Producto producto : pedido1.getCarrito()) {
			System.out.println(producto);
		}
		
		System.out.println("\nOrdenado por presio");
		ProcesadorDePedidos.ordenarProductosPorPrecio(pedido1, Comparator.comparing(Producto::precio).reversed());
		for (Producto producto : pedido1.getCarrito()) {
			System.out.println(producto);
		}
		
		try {
		    ProcesadorDePedidos.procesar(
		        pedido1,
		        new PagoCripto("1211aeff3c", 8000.0)
		    );
		} catch (FondosInsuficientesException e) {
		    System.err.println("Error: Fondos insuficientes. Detalle: " + e.getMessage());
		} catch (PagoFallidoException e) {
		    System.err.println("Error: Pago fallido. Detalle: " + e.getMessage());
		} catch (Exception e) {
		    System.err.println("Error inesperado al procesar el pago: " + e.getMessage());
		    e.printStackTrace(); 
		}
	}
}
