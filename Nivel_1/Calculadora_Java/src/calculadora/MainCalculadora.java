package calculadora;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCalculadora {
	public static Scanner entrada = new Scanner(System.in);
	public static PrintStream salida=new PrintStream(System.out);

	public static void main(String[] args) {
		crearNumeroEntero();

	}

	public static double crearNumero() {
		while (true) {
			try {
				salida.print(": ");
				return entrada.nextDouble();

			} catch (InputMismatchException e) {
				salida.println("Deben ingresar un numero entero\n" + e);
				entrada.next();
			}
		}
	}

	public static double crearNumeroEntero() {
		while (true) {
			try {
				salida.print(": ");
				return entrada.nextInt();

			} catch (InputMismatchException e) {
				salida.println("Deben ingresar un numero Entero\n" + e);
				entrada.next();
			}
		}
	}

	public static void menu() {
		salida.print("""
				Menu
				1. Suma
				2. Resta
				3. Multiplicación
				4. División
				5. Módulo
				opcion
				""");
	}


}
