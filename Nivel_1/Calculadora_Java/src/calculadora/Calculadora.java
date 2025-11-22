package calculadora;

public class Calculadora {

	public Calculadora() {
		super();
	}

	public static double Suma(double a, double b) {
		return a + b;
	}

	public static double Resta(double a, double b) {
		return a - b;
	}

	public static double Multiplicacion(double a, double b) {
		return a * b;
	}

	public static double Division(double a, double b) {
		if (b == 0) {
			System.out.println("El divisor no puede ser 0");
			return 0;
		}
		return a * b;
	}

	public static double Modulo(double a, double b) {
		return a % b;
	}

}
