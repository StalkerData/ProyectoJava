package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Estudiante;
import util.Herramientas;

public class EstudianteLista {
	private List<Estudiante> listaEstudiantes;

	public EstudianteLista() {
		listaEstudiantes = new ArrayList<Estudiante>();
	}

	public void registrar_estudiante() {
		String identificador, nombre;
		System.out.println("Registrar estudiantes");
		identificador = Herramientas.crearID();
		if (estaEstudiantes(identificador) != null) {
			System.out.println("El ID ya se encuentas intenta con otro");
			return;
		}
		nombre = Herramientas.crearNombre();
		listaEstudiantes.add(new Estudiante(identificador, nombre));
	}

	private Estudiante estaEstudiantes(String id) {
		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante.getIdentificador().equals(id)) {
				return estudiante;
			}
		}
		return null;
	}

	public void imprimir_lista() {
		System.out.println("Lista de estudiantes");
		if (listaEstudiantes.isEmpty()) {
			System.out.println("no hay estudiantes");
			return;
		}
		for (Estudiante estudiante : listaEstudiantes) {
			System.out.println(estudiante.toString());
		}

	}

	private float crearNota() {
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

	private void menuNota() {
		System.out.print("""
				Menu Nota
				1) agregar
				2) salir
				opcion""");

	}

	public List<Float> listaDeNotas() {
		List<Float> notas = new ArrayList<Float>();
		int op = 0;
		System.out.println();
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

	public float calcular_promedio(List<Float> listaNota) {
		if (listaNota == null)
			return 0.0f;
		float suma = 0.0f;
		for (Float nota : listaNota) {
			suma += nota;
		}
		return suma / (float) (listaNota.size());

	}

	public void consultar_estudiante() {
		System.out.println("Consultar a estudiante");
		if (listaEstudiantes.isEmpty()) {
			System.out.println("la lista esta vacia");
			return;
		}
		String identificador = Herramientas.crearID();
		Estudiante est = estaEstudiantes(identificador);
		if (est == null) {
			System.out.println("El estudiante no existe");
			return;
		}
		System.out.println(est);

	}

	public void registrar_nota() {
		System.out.println("Registrar nota a estudiante");
		if (listaEstudiantes.isEmpty()) {
			System.out.println("la lista esta vacia");
			return;
		}
		String identificador = Herramientas.crearID();
		Estudiante est = estaEstudiantes(identificador);
		if (est == null) {
			System.out.println("El estudiante no existe");
			return;
		}
		System.out.println("id: " + est.getIdentificador());
		System.out.println("nombre: " + est.getNombre());
		System.out.println();
		opcionesRegistro(est);

	}

	private void opcionesRegistro(Estudiante est) {
		int op = 0;
		while (op != 3) {
			System.out.println("Opciones de lista");
			System.out.print("""
					1. agregar nueva lista de notas
					2. agregar nota a lista ya existente
					3. salir
					opcones""");
			op = Herramientas.crearEntero();
			switch (op) {
			case 1:
				est.setLista_notas(listaDeNotas());
				break;
			case 2:
				if (est.getLista_notas() == null) {
					System.out.println("la lista es nula, tiene que agregarle una lista nueva");
					continue;
				}
				est.getLista_notas().addAll(listaDeNotas());
				break;
			case 3:
				System.out.println("regresanto al menu general");
				break;

			default:
				break;
			}
			System.out.println();
		}
	}

	public void calcular_promedio_estudiante() {
		System.out.println("Calcular promedio a estudiante");
		if (listaEstudiantes.isEmpty()) {
			System.out.println("la lista esta vacia");
			return;
		}
		String identificador = Herramientas.crearID();
		Estudiante est = estaEstudiantes(identificador);
		if (est == null) {
			System.out.println("El estudiante no existe");
			return;
		}
		System.out.println(est);
		System.out.println("promedio: " + calcular_promedio(est.getLista_notas()));
		System.out.println();
	}

}
