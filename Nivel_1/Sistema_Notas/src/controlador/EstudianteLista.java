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
		listaEstudiantes = new ArrayList<Estudiante>();
		registrar_estudiante();
		registrar_estudiante();
		registrar_estudiante();
		imprimir_lista();
	
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

}
