package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

	@Test
	void calculateWithoutDatePositiveTest() {
		double testSalary = 100000;
		int testDays = 28;
		VacationCalculator calculator = new VacationCalculator(testSalary, testDays);
		double expected = (double) Math.round(testSalary / 29.3 * testDays * 100) / 100;
		double result = calculator.calculate();
		assertEquals(expected, result);
	}

	@Test
	void calculateWithDatePositiveTest() {
		double testSalary = 100000;
		int testDays = 28;
		Date date = new Date(1,5,2024);
		VacationCalculator calculator = new VacationCalculator(testSalary, testDays, date);
		double expected = (double) Math.round(testSalary / 29.3 * (testDays - 2) * 100) / 100;
		double result = calculator.calculate();
		assertEquals(expected, result);
	}

	@Test
	void calculateNegativeSalaryNegativeTest() {
		double testSalary = -100000;
		int testDays = 28;
		VacationCalculator calculator = new VacationCalculator(testSalary, testDays);
		double expected = 0;
		double result = calculator.calculate();
		assertEquals(expected, result);
	}

	@Test
	void calculateNegativeDaysNegativeTest() {
		double testSalary = 100000;
		int testDays = -28;
		VacationCalculator calculator = new VacationCalculator(testSalary, testDays);
		double expected = 0;
		double result = calculator.calculate();
		assertEquals(expected, result);
	}

	@Test
	void calculateWrongDateNegativeTest() {
		double testSalary = 100000;
		int testDays = 28;
		Date date = new Date("1434235");
		VacationCalculator calculator = new VacationCalculator(testSalary, testDays);
		double expected = (double) Math.round(testSalary / 29.3 * testDays * 100) / 100;
		double result = calculator.calculate();
		assertEquals(expected, result);
	}
}
