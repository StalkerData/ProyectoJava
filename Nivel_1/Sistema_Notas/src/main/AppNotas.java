package main;

import controlador.EstudianteLista;
import util.Herramientas;

public class AppNotas {
	public EstudianteLista estudiantes;

	public static void main(String[] args) {
		System.out.println("Sistema de Notas en Consola");
		AppNotas app = new AppNotas();
		app.App();
		System.out.println("Fin Del programa");
	}

	public AppNotas() {
		this.estudiantes = new EstudianteLista();
	}

	public void menuApp() {
		System.out.print("""
				1. Registrar estudiante
				2. Registrar nota
				3. Calcular promedio
				4. Listar estudiantes
				5. Consultar estudiante
				6. Salir
				opcion""");
	}

	public void App() {
		int op = 0;
		while (op != 6) {
			menuApp();
			op = Herramientas.crearEntero();
			System.out.println();
			switch (op) {
			case 1:
				estudiantes.registrar_estudiante();
				break;
			case 2:
				estudiantes.registrar_nota();
				break;
			case 3:
				estudiantes.calcular_promedio_estudiante();
				break;
			case 4:
				estudiantes.imprimir_lista();
				break;
			case 5:
				estudiantes.consultar_estudiante();
				break;
			case 6:
				System.out.println("Hasta luego");
				break;
			default:
				System.out.println("Opcion equivocada");
				break;
			}
			System.out.println();

		}
	}
}
