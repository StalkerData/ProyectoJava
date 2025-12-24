package calculadora;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCalculadora {
	public Scanner entrada = new Scanner(System.in);
	public PrintStream salida = new PrintStream(System.out);

	public static void main(String[] args) {
		System.out.println("Calculadora en Java");
		MainCalculadora calc = new MainCalculadora();
		calc.app();
		System.out.println("Fin del Programa");
	}

	public double crearNumero() {
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

	public int crearNumeroEntero() {
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

	public void menu() {
		salida.print("""
				Menu
				1. Suma
				2. Resta
				3. Multiplicación
				4. División
				5. Módulo
				6. Salir
				opcion""");
	}

	public void fSuma() {
		System.out.println("Suma");
		System.out.print("ingrese el primer numero");
		double num1 = crearNumero();
		System.out.print("ingrese el segundo numero");
		double num2 = crearNumero();
		double result = Calculadora.Suma(num1, num2);
		System.out.println("El resultado es: " + result);
	}

	public void fResta() {
		System.out.println("Resta");
		System.out.print("ingrese el primer numero");
		double num1 = crearNumero();
		System.out.print("ingrese el segundo numero");
		double num2 = crearNumero();
		double result = Calculadora.Resta(num1, num2);
		System.out.println("El resultado es: " + result);
	}

	public void fMultiplicacion() {
		System.out.println("Multiplicacion");
		System.out.print("ingrese el primer numero");
		double num1 = crearNumero();
		System.out.print("ingrese el segundo numero");
		double num2 = crearNumero();
		double result = Calculadora.Multiplicacion(num1, num2);
		System.out.println("El resultado es: " + result);
	}

	public void fDivision() {
		System.out.println("Division");
		System.out.print("ingrese el primer numero");
		double num1 = crearNumero();
		System.out.print("ingrese el segundo numero");
		double num2 = crearNumero();
		if (num2 == 0) {
			System.out.println("El divisor no puede ser 0");
			return;
		}
		double result = Calculadora.Division(num1, num2);
		System.out.println("El resultado es: " + result);
	}

	public void fModulo() {
		System.out.println("Modulo");
		System.out.print("ingrese el primer numero");
		double num1 = crearNumero();
		System.out.print("ingrese el segundo numero");
		double num2 = crearNumero();
		if (num2 == 0) {
			System.out.println("El divisor no puede ser 0");
			return;
		}
		double result = Calculadora.Modulo(num1, num2);
		System.out.println("El resultado es: " + result);
	}

	public void opciones(int op) {
		switch (op) {
		case 1:
			fSuma();
			break;
		case 2:
			fResta();
			break;
		case 3:
			fMultiplicacion();
			break;
		case 4:
			fDivision();
			break;
		case 5:
			fModulo();
			break;
		case 6:
			System.out.println("Hasta luego");
			break;
		default:
			System.out.println("opcion erronea");
			break;
		}
	}

	public void app() {
		int op = 0;
		while (op != 6) {
			menu();
			op = crearNumeroEntero();
			System.out.println();
			opciones(op);
			System.out.println();
		}
		entrada.close();
		salida.close();
	}

}
