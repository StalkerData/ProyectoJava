package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Herramientas {
	private static Scanner entrada = new Scanner(System.in);

	public static int crearEntero() {
		while (true) {
			try {
				System.out.print(": ");
				return entrada.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("Deben ingresar un numero Entero\n" + e);
				entrada.next();
			}
		}

	}

	public static float crearReal() {
		while (true) {
			try {
				System.out.print(": ");
				return entrada.nextFloat();

			} catch (InputMismatchException e) {
				System.out.println("Deben ingresar un numero entero\n" + e);
				entrada.next();
			}
		}
	}

	public static boolean textoValido(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if (!Character.isLetter(c) && !Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static String crearNombre() {
		String nombre;
		while (true) {
			System.out.print("Ingrese el nombre (solo letras y numeros): ");
			nombre = entrada.nextLine();
			if (textoValido(nombre)) {
				return nombre;
			}
			System.out.println("Error: Solo se permiten letras y numeros. Intente de nuevo.");
		}
	}

	public static boolean idValido(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static String crearID() {
		String id;
		while (true) {
			System.out.print("Ingrese el ID (solo numeros): ");
			id = entrada.nextLine();
			if (idValido(id)) {
				return id;
			}
			System.out.println("Error: Solo se permiten números. Intente de nuevo.");
		}
	}
}
