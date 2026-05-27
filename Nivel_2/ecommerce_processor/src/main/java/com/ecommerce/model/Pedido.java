package main.java.com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private List<Producto> carrito;

	public Pedido(List<Producto> carrito) {
	    super();
	    this.carrito = new ArrayList<>(carrito); 
	}

	public List<Producto> getCarrito() {
	    return carrito.stream().toList(); 
	}

	public void setCarrito(List<Producto> carrito) {
	    this.carrito = new ArrayList<>(carrito); 
	}

}
