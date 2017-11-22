package gt.edu.url.problema3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HistoryTest {

	@Test(expected = IllegalArgumentException.class)
	public void demoBadLeak() {
		LeakyStack<Animal> animalHistory = new ImplLeakyStack<>(1);
		
		Animal bambi = new Animal("salvaje", 10, 100.00, "cafecito");
		
		bambi = animalHistory.saveHistory(bambi); //Push
		bambi.setSkinColor("café");
		bambi = animalHistory.saveHistory(bambi); //Push
		bambi.setSkinColor("café salvaje");
		assertEquals("café salvaje", bambi.getSkinColor());// Prints café salvaje
		bambi = animalHistory.undo(); //Pop		
		assertEquals("café", bambi.getSkinColor());
		bambi = animalHistory.undo(); //Raises IllegalArgumentException
	}
	
	@Test
	public void demoNoLeak() {
		LeakyStack<Animal> animalHistory = new ImplLeakyStack<>(2);
		
		Animal bambi = new Animal("salvaje", 10, 100.00, "cafecito");
		
		bambi = animalHistory.saveHistory(bambi); //Push
		bambi.setSkinColor("café");
		bambi = animalHistory.saveHistory(bambi); //Push
		bambi.setSkinColor("café salvaje");
		assertEquals("café salvaje", bambi.getSkinColor());// Prints café salvaje
		bambi = animalHistory.undo(); //Pop		
		assertEquals("café", bambi.getSkinColor());
		bambi = animalHistory.undo(); //Pop	
		assertEquals("cafecito", bambi.getSkinColor());
	}
	
	@Test
	public void demoLeak() {
		LeakyStack<Animal> animalHistory = new ImplLeakyStack<>(2);
		
		Animal bambi = new Animal("salvaje", 10, 100.00, "cafecito");
		bambi = animalHistory.saveHistory(bambi); //Push will be leaked
		bambi.setSkinColor("juan valdez");
		bambi = animalHistory.saveHistory(bambi); //Push
		bambi.setSkinColor("café");
		bambi = animalHistory.saveHistory(bambi); //Push
		bambi.setSkinColor("café salvaje");
		assertEquals("café salvaje", bambi.getSkinColor());// Prints café salvaje
		bambi = animalHistory.undo(); //Pop		
		assertEquals("café", bambi.getSkinColor());
		bambi = animalHistory.undo(); //Pop	
		assertEquals("juan valdez", bambi.getSkinColor());
	}

}
