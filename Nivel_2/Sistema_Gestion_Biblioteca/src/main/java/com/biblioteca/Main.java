package main.java.com.biblioteca;

import java.util.List;
import java.util.Map;

import main.java.com.biblioteca.model.*;
import main.java.com.biblioteca.service.BibliotecaService;

public class Main {

	public static void main(String[] args) {
		Main metodosMain= new Main();
		Libro libro1 = new Libro("L001", "Clean Code", 2008, "Uncle Bob", "978-0132350884");
		Libro libro2 = new Libro("L002", "Clean Software", 2009, "Uncle Josh", "978-0132350885");
		Libro libro3 = new Libro("L003", "Clean FireWall", 2010, "Uncle Steve", "978-0132350886");
		Libro libro4 = new Libro("L004", "Clean HTTP", 2011, "Uncle Jack", "978-0132350887");
		Revista revista1 = new Revista("R001", "National Geographic", 2023, 505);
		Usuario user1 = new Usuario("U001", "Pepito Perez");
		Usuario user2 = new Usuario("U002", "Pepito Torres");
		Usuario user3 = new Usuario("U003", "Pepito Gomez");
		BibliotecaService biblio = new BibliotecaService();
		System.out.println("Inicio del Programa");
		try {
			biblio.registrarUsuario(user1);
			biblio.registrarUsuario(user2);
			biblio.registrarUsuario(user3);
			biblio.registrarMaterial(revista1);
			biblio.registrarMaterial(libro1);
			biblio.registrarMaterial(libro2);
			biblio.registrarMaterial(libro3);
			biblio.registrarMaterial(libro4);
			biblio.prestarMaterial(user1.id(), libro1.getId());
			biblio.prestarMaterial(user2.id(), libro3.getId());
			biblio.prestarMaterial(user3.id(), libro2.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		imprimirLista(biblio.getHistorialPrestamos());
		imprimirMap(biblio.getInventario());
		imprimirMap(biblio.getUsuarios());
		System.out.println("Fin del programa");

	}

	public static <E> void imprimirLista(List<E> lista) {
		lista.forEach(System.out::println);
		System.out.println();
	}

	public static <K, V> void imprimirMap(Map<K, V> mapa) {
		for (Map.Entry<K, V> entry : mapa.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());

		}
		System.out.println();
	}

}
