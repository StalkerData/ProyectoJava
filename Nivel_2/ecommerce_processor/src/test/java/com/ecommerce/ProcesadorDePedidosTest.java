package test.java.com.ecommerce;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.ecommerce.model.Categoria;
import main.java.com.ecommerce.model.Pedido;
import main.java.com.ecommerce.model.Producto;
import main.java.com.ecommerce.service.ProcesadorDePedidos;

class ProcesadorDePedidosTest {
	private Pedido testPedido;
	private List<Producto> listProductos1;
	private List<Producto> listProductos2;
	private List<Producto> listProductos3;

	@BeforeEach
	void setUp() throws Exception {
		Producto p1 = new Producto("001", "Teclado", 100.0, Categoria.ELECTRONICA);
		Producto p2 = new Producto("002", "Camisa", 50.0, Categoria.ROPA);
		Producto p3 = new Producto("003", "Manzana", 2.0, Categoria.ALIMENTOS);
		Producto p4 = new Producto("004", "Laptop", 999.99, Categoria.ELECTRONICA);
		Producto p5 = new Producto("005", "Falda", 30.0, Categoria.ROPA);
		Producto p6 = new Producto("006", "Vestido", 50.0, Categoria.ROPA);
		listProductos1 = List.of(p1, p2, p3);
		listProductos2 = List.of(p1, p4, p2, p5, p6);
		listProductos3 = List.of(p3,p5,p1);
	}

	@Test
	void tesTotalSinImpuestos() {
		testPedido = new Pedido(listProductos1);
		assertEquals(152.0, ProcesadorDePedidos.calcularTotalSinImpuestos(testPedido));
	}
	
	@Test
	void tesTotalConImpuestos() {
		testPedido = new Pedido(listProductos1);
		assertEquals(177.1, ProcesadorDePedidos.calcularTotalConImpuestos(testPedido), 0.01);
	}
	
	@Test
	void testfiltrarPorCategoria() {
		testPedido = new Pedido(listProductos2);
		List<Producto> lista= ProcesadorDePedidos.filtrarPorCategoria(testPedido, Categoria.ELECTRONICA);
		assertEquals(2, lista.size());
	}
	
	@Test
	void testOrdenamiento() {
		testPedido = new Pedido(listProductos3);
		ProcesadorDePedidos.ordenarProductosPorPrecio(testPedido, Comparator.comparing(Producto::precio).reversed());
		assertTrue(listProductos3.getLast().equals(testPedido.getCarrito().getFirst()));
	}

}
