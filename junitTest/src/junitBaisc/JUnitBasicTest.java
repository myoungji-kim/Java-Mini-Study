package junitBaisc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitBasicTest {

	@BeforeAll
	// 현재 클래스의 모든 테스트 메소드 전에 실행 : 딱 한번 실행
	static void setUpBeforeClass() throws Exception {
		System.out.println("모든 테스트 메소드 실행 전 : 딱 한번 실행 (ex. DB)");
	}

	@AfterAll
	// 현재 클래스의 모든 테스트 메소드 후에 실행 : 딱 한번 실행
	static void tearDownAfterClass() throws Exception {
		System.out.println("모든 테스트 메소드 실행 후 : 딱 한번 실행 (ex. DB)");
	}

	@BeforeEach // ex. 로그인 기능
	// 각 테스트 메소드 전에 실행
	void setUp() throws Exception {
		System.out.println("각 테스트 메소드 실행 전");
	}

	@AfterEach // ex. 로그아웃 기능
	// 각 테스트 메소드 후에 실행
	void tearDown() throws Exception {
		System.out.println("각 테스트 메소드 실행 후");
	}

	@Test // ex. 게시글 등록
	void test() {
		System.out.println("테스트 메소드 실행");
	}
	
	@Test
	void test2() {
		System.out.println("테스트 메소드2 실행");
	}

}
