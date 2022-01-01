package model.domain;

public class Calculator {
	public int add(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}

	public int divide(int a, int b) {
		if (b != 0) {
			return a / b;
		} else {
			throw new ArithmeticException("0으로는 나눌 수 없습니다.");
//			System.out.println("0으로는 나눌 수 없습니다.");
//			return -9999999;
		}

	}

	public int multiple(int a, int b) {
		return a * b;
	}
}
