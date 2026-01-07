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
		System.out.println("Sistema de Notas en Consola");
		listaEstudiantes=new ArrayList<Estudiante>();
		App();
		System.out.println("Fin Del programa");

	}

	public static void registrar_estudiante() {
		String identificador, nombre;
		System.out.println("Registrar estudiantes");
		identificador = Herramientas.crearID();
		if (!listaEstudiantes.isEmpty() && estaEstudiantes(identificador) == null) {
			System.out.println("El ID ya se encuentas intenta con otro");
			return;
		}
		nombre = Herramientas.crearNombre();
		listaEstudiantes.add(new Estudiante(identificador, nombre));
	}

	public static Estudiante estaEstudiantes(String id) {
		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante.getIdentificador().equals(id)) {
				return estudiante;
			}
		}
		return null;
	}

	public static void imprimir_lista() {
		System.out.println("Lista de estudiantes");
		if(listaEstudiantes.isEmpty()) {
			System.out.println("no hay estudiantes");
			return;
		}
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

	public static float calcular_promedio(List<Float> listaNota) {
		if (listaNota.isEmpty())
			return 0.0f;
		float suma = 0.0f;
		for (Float nota : listaNota) {
			suma += nota;
		}
		return suma / (float) (listaNota.size());

	}

	public static void consultar_estudiante() {
		System.out.println("Consultar a estudiante");
		String identificador = Herramientas.crearID();
		Estudiante est = estaEstudiantes(identificador);
		if (!listaEstudiantes.isEmpty() && est == null) {
			System.out.println("El estudiante no existe");
			return;
		}
		System.out.println(est);

	}

	public static void registrar_nota() {
		System.out.println("Registrar nota a estudiante");
		String identificador = Herramientas.crearID();
		Estudiante est = estaEstudiantes(identificador);
		if (!listaEstudiantes.isEmpty() && est == null) {
			System.out.println("El estudiante no existe");
			return;
		}
		System.out.println("id: " + est.getIdentificador());
		System.out.println("nombre: " + est.getNombre());
		est.setLista_notas(listaDeNotas());
	}

	public static void calcular_promedio_estudiante() {
		System.out.println("Calcular promedio a estudiante");
		String identificador = Herramientas.crearID();
		Estudiante est = estaEstudiantes(identificador);
		if (est == null) {
			System.out.println("El estudiante no existe");
			return;
		}
		System.out.println(est);
		System.out.println("promedio: " + calcular_promedio(est.getLista_notas()));
	}

	public static void menuApp() {
		System.out.print("""
				1. Registrar estudiante X
				2. Registrar nota X
				3. Calcular promedio X
				4. Listar estudiantes X
				5. Consultar estudiante X
				6. Salir
				opcion""");
	}

	public static void App() {
		int op = 0;
		while (op != 6) {
			menuApp();
			op = Herramientas.crearEntero();
			switch (op) {
			case 1:
				registrar_estudiante();
				break;
			case 2:
				registrar_nota();
				break;
			case 3:
				calcular_promedio_estudiante();
			case 4:
				imprimir_lista();
				break;
			case 5:
				consultar_estudiante();
				break;
			case 6:
				System.out.println("Hasta luego");
				break;
			default:
				System.out.println("Opcion equivocada");
				break;
			}

		}
	}
	/*
	 * hay problemas con el tema de la listas cuando son vacias
	 * hay que verificar cuando imprimir
	 * revisar esta estudiante
	 */

}
