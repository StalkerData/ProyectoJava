package test.java.com.rpg;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.com.rpg.models.Guerrero;
import main.java.com.rpg.models.Mago;

class PersonajeTest {
	private Guerrero guerrero;
	private Mago mago;

	@BeforeEach
	void setUp() {

	}

	@Test
	void lifeReductionTest() {
		guerrero = new Guerrero("conal", 50, 20);
		mago = new Mago("merlin", 50, 12);
		guerrero.atacar(mago);
		assertEquals(26, mago.getHp());
	}
	
	@Test
	void stateChangeTest() throws Exception {
		guerrero = new Guerrero("conal", 20, 20);
		mago = new Mago("merlin", 50, 50);
		mago.atacar(guerrero);
		
		assertFalse(guerrero.isEstaVivo(), "El guerrero debería estar muerto");
		assertEquals(0, guerrero.getHp(), "La vida no debe ser negativa, debe quedar en 0");
	}

	
	@Test
	void healingLimitTest() {
		guerrero = new Guerrero("conal", 100, 20);
		mago = new Mago("merlin", 50, 2);
		mago.atacar(guerrero);
		mago.Curable(guerrero);
		assertEquals(guerrero.getHp(),100);
		
	}

}
