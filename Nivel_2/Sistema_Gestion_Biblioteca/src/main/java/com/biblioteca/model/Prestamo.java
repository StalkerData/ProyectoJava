package main.java.com.biblioteca.model;

import java.time.LocalDate;

public class Prestamo {
	private final Usuario usuario;
	private final Material material;
	private final LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;

	public Prestamo(Usuario usuario, Material material) {
		this.usuario = usuario;
		this.material = material;
		this.fechaPrestamo = LocalDate.now();
		this.fechaDevolucion = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Material getMaterial() {
		return material;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void registrarDevolucion() {
		if (fechaDevolucion == null) {
			this.fechaDevolucion = LocalDate.now();
		} else {
			System.out.println("\nYa fue devuelto el material");
		}
	}

	@Override
	public String toString() {
		return "Prestamo [usuario=" + usuario + ", material=" + material + ", fechaPrestamo=" + fechaPrestamo
				+ ", fechaDevolucion=" + fechaDevolucion + "]";
	}

}
