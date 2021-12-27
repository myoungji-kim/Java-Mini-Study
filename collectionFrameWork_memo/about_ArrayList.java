package step01.collection;

import java.util.ArrayList;
import model.domain.Student;

public class Ex01ArrayListTest {
	public static void main(String[] args) {
		// ArrayList
		ArrayList arr1 = new ArrayList();
		
		
		// add() : ArrayList에 객체를 저장하는 메소드
		arr1.add("ArrayList_TEST");
		arr1.add(3);
		arr1.add(new Student("ddingji", 1, "high-class"));
		System.out.println(arr1);
		
		// get() : 인덱트 번호를 이용하여 값을 가져올 수 있는 메소드
		System.out.println(arr1.get(0));
//		System.out.println(arr1.get(1));
//		System.out.println(arr1.get(2));


		// size() : ArrayList가 갖고 있는 데이터의 개수 
		System.out.println(arr1.size());
		
		
		// remove() : 
//		arr1.remove(0);

		// arr1 출력
		System.out.println("---arr1 출력---");
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
		
		System.out.println("------------------------------------------");
		
		
		// 제네릭(Generic) : 타입 사전 설정, 반환값 확인 및 타입 변환과 검사 최소화
		ArrayList<String> arr2 = new ArrayList<String>();
		arr2.add("ArrayList2");
//		arr2.add(3);
		for (int i = 0; i < arr2.size(); i++) {
			System.out.println(arr2.get(i).length());
		}
		
		// int는 객체 타입이 아니라 안됨
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		arr3.add(10);
		System.out.println(arr3);
		
		System.out.println(arr3.get(0).getClass());
	}
}
