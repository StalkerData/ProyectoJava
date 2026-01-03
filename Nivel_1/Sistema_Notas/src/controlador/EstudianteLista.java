package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Estudiante;
import util.Herramientas;

public class EstudianteLista {
	public static List<Estudiante> listaEstudiantes;
	public static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * listaEstudiantes = new ArrayList<Estudiante>(); registrar_estudiante();
		 * registrar_estudiante(); registrar_estudiante(); imprimir_lista();
		 */
		System.out.println(listaDeNotas());

	}

	public static void registrar_estudiante() {
		String identificador, nombre;
		System.out.println("Registrar estudiantes");
		identificador = Herramientas.crearID();
		nombre = Herramientas.crearNombre();
		listaEstudiantes.add(new Estudiante(identificador, nombre));
	}

	public static void imprimir_lista() {
		System.out.println("Lista de estudiantes");
		for (Estudiante estudiante : listaEstudiantes) {
			System.out.println(estudiante.toString());
		}

	}

	public static float crearNota() {
		while (true) {
			System.out.print("Ingrese la Nota(0-5)");
			float nota = Herramientas.crearReal();
			if (nota < 0f | nota > 5f) {
				System.out.println("El numero debe estar entre 0-5\n");
				continue;
			}
			return nota;
		}

	}

	public static void menuNota() {
		System.out.print("""
				Menu Nota
				1) agregar
				2) salir
				opcion""");

	}

	public static List<Float> listaDeNotas() {
		List<Float> notas = new ArrayList<Float>();
		int op = 0;
		while (op != 2) {
			menuNota();
			op = Herramientas.crearEntero();
			switch (op) {
			case 1:
				notas.add(crearNota());
				break;
			case 2:
				System.out.println("Regresando al menu principal");
				break;
			default:
				System.out.println("Opcion equivocada");
				break;
			}
			System.out.println();
		}
		return notas;
	}

}
