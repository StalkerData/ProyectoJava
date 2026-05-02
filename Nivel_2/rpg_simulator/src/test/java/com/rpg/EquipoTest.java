package test.java.com.rpg;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.com.rpg.core.Equipo;
import main.java.com.rpg.exception.LimiteEquipoSuperado;
import main.java.com.rpg.models.Arquero;
import main.java.com.rpg.models.Guerrero;
import main.java.com.rpg.models.Mago;
import main.java.com.rpg.models.Personaje;

class EquipoTest {
	private Equipo<Personaje> equipoPersonajes;

	@BeforeEach
	void setUp()  throws LimiteEquipoSuperado{
		equipoPersonajes = new Equipo<>("Equipo de Prueba");

        Personaje personaje1 = new Guerrero("Guerrero", 100, 50);
        Personaje personaje2 = new Arquero("Arquero", 100, 50);
        Personaje personaje3 = new Mago("Mago", 100, 100);
        personaje3.atacar(personaje2);
        personaje1.atacar(personaje3);
        equipoPersonajes.agregarMiembro(personaje1);
		equipoPersonajes.agregarMiembro(personaje2);
		equipoPersonajes.agregarMiembro(personaje3);

	}
	
	@Test
	void limiteEquipoTest() {
		assertThrows(LimiteEquipoSuperado.class, () -> {
			equipoPersonajes.agregarMiembro(new Mago("Zardo", 80, 8));
		});
	}

	@Test
    void masHeridoTest() {
        Personaje masHerido = equipoPersonajes.masHerido();
        assertEquals("Mago", masHerido.getNombre(), "El personaje más herido debería ser el Mago con 50/100 HP.");
    }

	
}
