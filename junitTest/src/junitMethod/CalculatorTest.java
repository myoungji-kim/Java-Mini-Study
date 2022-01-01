package junitMethod;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.domain.Calculator;

class CalculatorTest {
	Calculator calculator = new Calculator();
	
	@Test
	void testAdd() {
		assertEquals(9, calculator.add(3, 5));
	}

}
