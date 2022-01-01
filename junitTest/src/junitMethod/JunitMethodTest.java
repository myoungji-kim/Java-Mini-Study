package junitMethod;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.domain.Calculator;

class JunitMethodTest {
	
	Calculator calculator = new Calculator();
	
	@Test
	@Disabled 
	@DisplayName("assertEquals")
	void testAdd() {
		assertEquals(9, calculator.add(3, 5)); // 기대값, 실제값
		assertEquals(4, calculator.add(2, 7));
	}
	
	@Test
	@Disabled 
	@DisplayName("assertAll") // Junit 창에서 보여지는 메소드명 변경
	void assertEqualsTest() {
		// 한번에 여러 개 검증해주는 메소드
		// 틀린 모든 케이스의 에러 메시지를 확인할 수 있음 -> Failure Trace
		assertAll(
				() -> assertEquals(9, calculator.add(3, 5)),
				() -> assertEquals(8, calculator.add(2, 5)),
				() -> assertEquals(7, calculator.add(6, 4))
		);
	}
	
	@Test
	@Disabled // 이거 붙은 메소드는 실행 안함
	@DisplayName("assertArrayEquals")
	void assertArrayEqualsTest() {
		int[] i1 = { 1 };
		int[] i2 = { 2 };
		
		assertArrayEquals(i1, i2);
	}
	
	@Test
	@Disabled // 이거 붙은 메소드는 실행 안함
	@DisplayName("assertSame")
	void assertSameTest() {
		// 에러
		Object o1 = new Object();
		Object o2 = new Object();
//		assertSame(o1, o2);

		// 통과
		String str1 = "String";
		String str2 = "String";
//		assertSame(str1, str2);
	}
	
	@Test
	@Disabled // 이거 붙은 메소드는 실행 안함
	@DisplayName("assertTrueFalse")
	void assertTrueFalseTest() {
		assertFalse( 1 < 5 );
	}
	
	@Test
	@Disabled // 이거 붙은 메소드는 실행 안함
	@DisplayName("assertNotNull")
	void assertNotNullTest() {
		Object obj = null;
		
//		assertNotNull(obj); 	// 에러
		assertNull(obj);		// 통과
	}
	
	@Test
	@Disabled // 이거 붙은 메소드는 실행 안함
	@DisplayName("assumeTrueFalse")
	void assumeTrueFalseTest() {
		assumeTrue( 5 > 1 );	// 통과
		assumeFalse( 5 > 1 );	// 통과
	}
	
	@Test
	@Disabled // 이거 붙은 메소드는 실행 안함
	@DisplayName("assumingThat") // 조건에 대한 검증을 검사 
	void assumingThatTest() {
		String str = "String";
		assumingThat(
				str.equals("String"),
				() -> System.out.println("참일때 실행되는 메소드")
		);
	}
	
	@Test
//	@Disabled // 이거 붙은 메소드는 실행 안함
	void exceptionTest() {
		ArithmeticException exception = assertThrows(ArithmeticException.class, 
										() -> calculator.divide(1, 0)
										);
		assertEquals("", exception.getMessage());
	}

}
