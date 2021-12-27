package step01.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import model.domain.Student;

public class Ex03HashMapTest {
	public static void main(String[] args) {
		// HashMap<K, V>
		HashMap<String, Integer> hMap1 = new HashMap<String, Integer>();
		
		// put() : 저장
		hMap1.put("a", 1);
		hMap1.put("b", 2);
		hMap1.put("c", 3);
		hMap1.put("d", 4);
		System.out.println(hMap1);

		System.out.println("+--------------------------+");
		
		// get() : key로 value 반환
		System.out.println(hMap1.get("c"));  // 3
		System.out.println(hMap1.get("ddingji"));  // null
		
		System.out.println("+--------------------------+");
		
		// remove() : 해당 key와 value 삭제
		hMap1.remove("b");
		System.out.println(hMap1);
		System.out.println(hMap1.get("b"));

		System.out.println("+--------------------------+");
		
		// HashMap<String, Student>
		HashMap<String, Student> hMap2 = new HashMap<String, Student>();
		hMap2.put("k1", new Student("DDingji", 1, "top"));
		System.out.println(hMap2); // {k1=DDingji, 1, top}
		
		// Student 객체 접근 가능
		System.out.println(hMap2.get("k1")); // DDingji, 1, top
		System.out.println(hMap2.get("k1").getGrade()); // top

		
		// HashMap<String, ArrayList>
		ArrayList<String> arr3 = new ArrayList<String>();
		arr3.add("a");
		arr3.add("b");
		arr3.add("c");
		arr3.add("d");
		HashMap<String, ArrayList> hMap3 = new HashMap<String, ArrayList>();
		hMap3.put("k3", arr3);
		
		System.out.println(hMap3.get("k3").get(0));
		
		System.out.println("+--------------------------+");
		// HashMap<String, HashMap>
		HashMap<String, HashMap> hMap4 = new HashMap<String, HashMap>();
		hMap4.put("k4", hMap3);
		
		// (hMap4) 객체를 이용해서 b 출력하기
		System.out.println("(hMap4) 객체를 이용해서 b 출력하기");
		
		// HashMap에 들어갈 때 Object로 들어가있음, 따로 정의를 안해줘서
		// hMap4를 만들 때, HashMap에 ArrayList를 선언해주지 않은 상태임
		System.out.println(((ArrayList) hMap4.get("k4").get("k3")).get(1));
		// System.out.println(hMap4.get("k4").get("k3").toString().charAt(4) );
		
		// key값을 모를때?! 전체 출력하기
		// keySet() : 
		System.out.println("+----keySet()----+");
		Set<String> keySet = hMap1.keySet();
		System.out.println("keySet: "+keySet);
		System.out.println("hMap1.values(): "+hMap1.values());
		
		// 각각의 모든 키값을 가져와서 필요한 거 찾을 때 -> Iterator
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
//			System.out.println(iter.next()); -> key값 출력
			String key = iter.next(); 
			if(key.equals("d")) {
				int value = hMap1.get(key);
				System.out.println(key + " " + value);
			}
		}
		
		
	}
}



























