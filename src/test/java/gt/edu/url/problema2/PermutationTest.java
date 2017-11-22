package gt.edu.url.problema2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermutationTest {

	@Test
	public void test3Perms() {
		ArrayManipulator<String> list = new ImplArrayManipulator<>();
		List<String> leList = new ArrayList<>();
		leList.add(0, "a");
		leList.add(0, "b");
		leList.add(0, "c");
		
		assertEquals(6, list.subsets(leList));
	}
	
	@Test
	public void test4Perms() {
		ArrayManipulator<String> list = new ImplArrayManipulator<>();
		List<String> leList = new ArrayList<>();
		leList.add(0, "a");
		leList.add(0, "b");
		leList.add(0, "c");
		leList.add(0, "d");
		assertEquals(24, list.subsets(leList));
	}
	
	@Test
	public void test8Perms() {
		ArrayManipulator<String> list = new ImplArrayManipulator<>();
		List<String> leList = new ArrayList<>();
		leList.add(0, "1");
		leList.add(0, "2");
		leList.add(0, "3");
		leList.add(0, "4");
		leList.add(0, "5");
		leList.add(0, "6");
		leList.add(0, "7");
		leList.add(0, "8");
		assertEquals(40320, list.subsets(leList));
	}

}
