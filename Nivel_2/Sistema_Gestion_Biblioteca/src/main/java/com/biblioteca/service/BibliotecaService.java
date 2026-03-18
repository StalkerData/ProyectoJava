package main.java.com.biblioteca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.java.com.biblioteca.exception.IdDuplicadoException;
import main.java.com.biblioteca.exception.IdNoEncontrado;
import main.java.com.biblioteca.exception.MaterialNoDisponibleException;
import main.java.com.biblioteca.interfaces.Prestable;
import main.java.com.biblioteca.model.*;

public class BibliotecaService {
	private Map<String, Material> inventario;
	private Map<String, Usuario> usuarios;
	private List<Prestamo> historialPrestamos;

	public BibliotecaService() {
		this.inventario = new HashMap<>();
		this.usuarios = new HashMap<>();
		this.historialPrestamos = new ArrayList<>();
	}

	public void registrarMaterial(Material material) {
		if (inventario.containsKey(material.getId())) {
			throw new IdDuplicadoException(material.getId());
		}
		inventario.put(material.getId(), material);
	}

	public void registrarUsuario(Usuario usuario) {
		if (usuarios.containsKey(usuario.id())) {
			throw new IdDuplicadoException(usuario.id());
		}
		usuarios.put(usuario.id(), usuario);
	}

	public void prestarMaterial(String idUsuario, String idMaterial) throws Exception {
		Usuario u = buscarUsuario(idUsuario);
		if (u == null) {
			throw new IdNoEncontrado(
					String.format("El id: %s, no se encuentra registrado en los usuarios.", idUsuario));
		}
		Material m = buscarMaterial(idMaterial);
		if (m == null) {
			throw new IdNoEncontrado(
					String.format("El id: %s, no se encuentra registrado en el inventario.", idMaterial));

		}
		if (!(m instanceof Prestable)) {
			throw new MaterialNoDisponibleException(
					String.format("El material: %s, no es prestable.", m.getTipoMaterial()));
		}

		Prestable itemPrestable = (Prestable) m;
		itemPrestable.prestar();

		historialPrestamos.add(new Prestamo(u, m));

	}

	public void devolverMaterial(String idMaterial) throws Exception {
		Material m = buscarMaterial(idMaterial);
		if (m == null) {
			throw new IdNoEncontrado(
					String.format("El id: %s, no se encuentra registrado en el inventario.", idMaterial));

		}
		if (!(m instanceof Prestable)) {
			throw new MaterialNoDisponibleException(
					String.format("El material: %s, no es prestable.", m.getTipoMaterial()));
		}

		Optional<Prestamo> prestamo = buscarPrestamo(m);
		if (prestamo.isEmpty()) {
			throw new Exception("No hay préstamos activos para este material.");
		}
		Prestable itemPrestable = (Prestable) m;
		itemPrestable.devolver();

		prestamo.get().registrarDevolucion();

	}

	public Material buscarMaterial(String id) {
		return inventario.get(id);
	}

	public Usuario buscarUsuario(String id) {
		return usuarios.get(id);
	}

	public Optional<Prestamo> buscarPrestamo(Material m) {
		return historialPrestamos.stream()
				.filter(prestamo -> prestamo.getMaterial().equals(m) && prestamo.getFechaDevolucion() == null)
				.findFirst();
	}

}
