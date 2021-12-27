package step01.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Ex02HashSetTest {
	public static void main(String[] args) {
		// HashSet
		Set<String> set = new HashSet<String>();
		
		// set : 중복되는 데이터들은 자동 삭제 
		set.add("Happy");
		set.add("New");
		set.add("Year");
		System.out.println(set);
		
		set.add("Happy");
		System.out.println(set);
		
		// size() : 저장 객체 수
		System.out.println(set.size());
		
		// 출력
		for (String str : set) {
			System.out.println(str);
		}
		
		System.out.println();
		
		// 저장되어 있는 데이터를 가져오는거..! Iterator
		Iterator<String> iter = set.iterator();
		// hasNext => 그 다음에 출력할 값이 있니? (boolean)
		// next => 출력할 데이터 값을 가져오는 메소드
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		
		// 확인
		System.out.println(set.isEmpty());
		System.out.println(set.contains("New"));  // true
		System.out.println(set.contains("new"));  // false
		
	}
}
