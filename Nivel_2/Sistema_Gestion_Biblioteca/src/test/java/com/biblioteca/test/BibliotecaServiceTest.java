package test.java.com.biblioteca.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.com.biblioteca.exception.IdDuplicadoException;
import main.java.com.biblioteca.exception.IdNoEncontrado;
import main.java.com.biblioteca.exception.MaterialNoDisponibleException;
import main.java.com.biblioteca.model.Libro;
import main.java.com.biblioteca.model.Revista;
import main.java.com.biblioteca.model.Usuario;
import main.java.com.biblioteca.service.BibliotecaService;

class BibliotecaServiceTest {

	private BibliotecaService servicio;
	private Libro libroJava;
	private Usuario usuarioPepe;

	// Se ejecuta antes de CADA test para tener un ambiente limpio
	@BeforeEach
	void setUp() {
		servicio = new BibliotecaService();
		libroJava = new Libro("L001", "Java a Fondo", 2022, "Pablo", "999-99");
		usuarioPepe = new Usuario("U001", "Pepe Perez");

		// Registramos datos base para las pruebas
		servicio.registrarMaterial(libroJava);
		servicio.registrarUsuario(usuarioPepe);
	}

	@Test
	void testRegistrarMaterialDuplicadoLanzaExcepcion() {
		Libro libroDuplicado = new Libro("L001", "Otro Titulo", 2023, "Otro", "111");

		assertThrows(IdDuplicadoException.class, () -> {
			servicio.registrarMaterial(libroDuplicado);
		});
	}

	@Test
	void testPrestarMaterialExitoso() {
		assertDoesNotThrow(() -> {
			servicio.prestarMaterial("U001", "L001");
		});

		// Verificamos efectos colaterales
		assertFalse(libroJava.isDisponible(), "El libro debería marcarse como no disponible en el sistema");
	}

	@Test
	void testPrestarMaterialNoExistente() {
		assertThrows(IdNoEncontrado.class, () -> {
			servicio.prestarMaterial("U001", "ID_INEXISTENTE");
		});
	}

	@Test
	void testPrestarMaterialYaPrestado() throws Exception {
		// 1. Prestamos el libro primero
		servicio.prestarMaterial("U001", "L001");

		// 2. Intentamos prestarlo de nuevo al mismo u otro usuario
		assertThrows(MaterialNoDisponibleException.class, () -> {
			servicio.prestarMaterial("U001", "L001");
		});
	}

	@Test
	void testPrestarMaterialNoPrestable() {
		// Creamos una revista (asumiendo que Revista extiende Material pero NO
		// implementa Prestable)
		Revista revista = new Revista("R001", "Vogue", 2023, 5);
		servicio.registrarMaterial(revista);

		assertThrows(MaterialNoDisponibleException.class, () -> {
			servicio.prestarMaterial("U001", "R001");
		});
	}

	@Test
	void testDevolverMaterialExitoso() throws Exception {
		// Arrange: Prestamos primero
		servicio.prestarMaterial("U001", "L001");

		// Act: Devolvemos
		servicio.devolverMaterial("L001");

		// Assert: Verificamos estado
		assertTrue(libroJava.isDisponible());
	}

	@Test
	void testDevolverMaterialNoPrestado() {
		// Intentamos devolver algo que nunca se prestó
		Exception ex = assertThrows(Exception.class, () -> {
			servicio.devolverMaterial("L001");
		});

		assertEquals("No hay préstamos activos para este material.", ex.getMessage());
	}
}