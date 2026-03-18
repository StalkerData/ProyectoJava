package test.java.com.biblioteca.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import main.java.com.biblioteca.exception.MaterialNoDisponibleException;
import main.java.com.biblioteca.model.Libro;

class LibroTest {

	@Test
	void testCrearLibro() {
		Libro libro = new Libro("L01", "Java 17", 2021, "Gosling", "12345");
		assertTrue(libro.isDisponible(), "El libro nuevo debería estar disponible");
	}

	@Test
	void testPrestarLibroCambiaEstado() throws Exception {
		// Arrange
		Libro libro = new Libro("L01", "Java 17", 2021, "Gosling", "12345");

		// Act
		libro.prestar();

		// Assert
		assertFalse(libro.isDisponible(), "El libro prestado debería tener disponible=false");
	}

	@Test
	void testPrestarLibroYaPrestadoLanzaExcepcion() throws Exception {
		// Arrange
		Libro libro = new Libro("L01", "Java 17", 2021, "Gosling", "12345");
		libro.prestar(); // Lo prestamos la primera vez

		// Act & Assert
		Exception exception = assertThrows(MaterialNoDisponibleException.class, () -> {
			libro.prestar(); // Intentamos prestarlo de nuevo
		});

		assertTrue(exception.getMessage().contains("no se puede prestar"));
	}

	@Test
	void testDevolverLibro() throws Exception {
		// Arrange
		Libro libro = new Libro("L01", "Java 17", 2021, "Gosling", "12345");
		libro.prestar();

		// Act
		libro.devolver();

		// Assert
		assertTrue(libro.isDisponible(), "El libro devuelto debería estar disponible");
	}
}