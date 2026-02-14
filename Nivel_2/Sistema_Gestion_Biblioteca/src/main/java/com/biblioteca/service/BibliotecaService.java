package main.java.com.biblioteca.service;

import java.util.List;
import java.util.Map;

import main.java.com.biblioteca.exception.IdDuplicadoException;
import main.java.com.biblioteca.exception.IdNoEncontrado;
import main.java.com.biblioteca.exception.MaterialNoDisponibleException;
import main.java.com.biblioteca.model.*;

public class BibliotecaService {
	private Map<String, Material> inventario;
	private Map<String, Usuario> usuarios;
	private List<Prestamo> historialPrestamos;

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
		if (m instanceof Revista) {
			throw new MaterialNoDisponibleException(
					String.format("Este material: %s, no se puede prestar", m.getTipoMaterial()));
		}

	}

	public void devolverMaterial(String idMaterial) {

	}

	public Material buscarMaterial(String id) {
		return inventario.get(id);
	}

	public Usuario buscarUsuario(String id) {
		return usuarios.get(id);
	}

}
