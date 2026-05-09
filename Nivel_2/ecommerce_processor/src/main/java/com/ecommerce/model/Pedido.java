package main.java.com.ecommerce.model;

import java.util.List;

public class Pedido {
	private List<Producto> carrito;

	public Pedido(List<Producto> carrito) {
		super();
		this.carrito = carrito;
	}

	public List<Producto> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Producto> carrito) {
		this.carrito = carrito;
	}

}
