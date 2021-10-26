package runtime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RuntimeTest {
	
	@Test
	void eg1Test() {
		Runtime r = new Runtime();
		r.readFromFile("eg1.pgm");
		r.run();
		assertEquals(r.toString(), "Pgm   : [push 5.0, push 3.4567, add, pop m0, exit]\n" + 
				"Pc    : 6\n" + 
				"Stack : []\n" + 
				"Memory: [8.4567, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]\n" + 
				"------------------------------------------------\n");
	}
	
	@Test
	void eg2Test() {
		Runtime r = new Runtime();
		r.readFromFile("eg2.pgm");
		r.run();
		assertEquals(r.toString(), "Pgm   : [push 5.0, pop m0, push m0, push m0, label l2, dec, jmpz done, pop m0, push m0, mul, push m0, jmp l2, label done, pop m0, exit]\n" + 
				"Pc    : 16\n" + 
				"Stack : [120.0]\n" + 
				"Memory: [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]\n" + 
				"------------------------------------------------\n");
	}
	
	@Test
	void eg3Test() {
		Runtime r = new Runtime();
		r.readFromFile("eg3.pgm");
		assertThrows(java.util.EmptyStackException.class, () -> r.run());
	}

	@Test
	void eg4Test() {
		Runtime r = new Runtime();
		r.readFromFile("eg4.pgm");
		r.run();
		assertEquals(r.toString(), "Pgm   : [push 5.0, pop m0, exit]\n" + 
				"Pc    : 4\n" + 
				"Stack : []\n" + 
				"Memory: [5.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]\n" + 
				"------------------------------------------------\n");
	}
	
	@Test
	void eg5Test() {
		Runtime r = new Runtime();
		r.readFromFile("eg5.pgm");
		assertThrows(IllegalStateException.class, () -> r.run());
	}
	
	@Test
	void eg6Test() {
		Runtime r = new Runtime();
		r.readFromFile("eg6.pgm");
		r.run();
		assertEquals(r.toString(), "Pgm   : [push 5.0, push 5.0, div, pop m9, exit]\n" + 
				"Pc    : 6\n" + 
				"Stack : []\n" + 
				"Memory: [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0]\n" + 
				"------------------------------------------------\n");
	}
	
	@Test
	void eg7Test() {
		Runtime r = new Runtime();
		r.readFromFile("eg7.pgm");
		r.run();
		assertEquals(r.toString(), "Pgm   : [push 5.0, push 4.0, push 3.0, push 2.0, push 1.0, pop m1, pop m2, pop m3, pop m4, pop m5, exit]\n" + 
				"Pc    : 12\n" + 
				"Stack : []\n" + 
				"Memory: [0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 0.0, 0.0, 0.0, 0.0]\n" + 
				"------------------------------------------------\n");
	}
	
	@Test
	void eg8Test() {
		Runtime r = new Runtime();
		r.readFromFile("eg8.pgm");
		r.run();
		assertEquals(r.toString(), "Pgm   : [push 4.0, push 2.0, pop m8, pop m7, push m8, push m7, exit]\n" + 
				"Pc    : 8\n" + 
				"Stack : [2.0, 4.0]\n" + 
				"Memory: [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 4.0, 2.0, 0.0]\n" + 
				"------------------------------------------------\n");
	}
	
	@Test
	void eg9Test() {
		Runtime r = new Runtime();
		r.readFromFile("eg9.pgm");
		r.run();
		assertEquals(r.toString(), "Pgm   : [exit]\n" + 
				"Pc    : 2\n" + 
				"Stack : []\n" + 
				"Memory: [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]\n" + 
				"------------------------------------------------\n");
	}
	
	@Test
	void eg10Test() {
		Runtime r = new Runtime();
		r.readFromFile("eg10.pgm");
		r.run();
		assertEquals(r.toString(), "Pgm   : [push 2.0, push 5.0, sub, jmp leave, push 3.0, pop m0, push 2.0, label leave, exit]\n" + 
				"Pc    : 10\n" + 
				"Stack : [3.0]\n" + 
				"Memory: [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]\n" + 
				"------------------------------------------------\n");
	}
}
