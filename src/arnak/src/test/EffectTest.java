package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import arnak.Effect;

class EffectTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEffects() {
		Effect e1 = new Effect(1);
		assertEquals("Gained 2 golden coins", e1.useEffect());
		e1 = new Effect(2);
		assertEquals("Gained 2 compasses", e1.useEffect());
		e1 = new Effect(3);
		assertEquals("Gained 3 golden coins", e1.useEffect());
		e1 = new Effect(4);
		assertEquals("Gained 3 compasses", e1.useEffect());
		e1 = new Effect(5);
		assertEquals("Gained 1 perl", e1.useEffect());
		e1 = new Effect(6);
		assertEquals("Gained 2 perls", e1.useEffect());
		e1 = new Effect(7);
		assertEquals("Gained 2 golden coins", e1.useEffect());
		e1 = new Effect(8);
		assertEquals("Draw Card", e1.useEffect());
		e1 = new Effect(9);
		assertEquals("Make Trade", e1.useEffect());
		e1 = new Effect(10);
		assertEquals("Gain Fear Card", e1.useEffect());
	}

}
