package main.java.com.biblioteca;

import main.java.com.biblioteca.model.*;
import main.java.com.biblioteca.service.BibliotecaService;

public class Main {

	public static void main(String[] args) {
		Libro libro1 = new Libro("L001", "Clean Code", 2008, "Uncle Bob", "978-0132350884");
		Revista revista1 = new Revista("R001", "National Geographic", 2023, 505);
		Usuario user1 = new Usuario("U001", "Pepito Perez");
		BibliotecaService biblio = new BibliotecaService();
		System.out.println("Inicio del Programa");
		try {
			biblio.registrarUsuario(user1);
			biblio.registrarMaterial(revista1);
			biblio.registrarMaterial(libro1);
			biblio.prestarMaterial(user1.id(),libro1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin del programa");

	}

}
