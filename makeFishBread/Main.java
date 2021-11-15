package makeFishBread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	//
	static String[] ingsArray = {"팥", "슈크림", "초코", "밀가루"};
	static ArrayList<String>  ingsList = new ArrayList<>(Arrays.asList(ingsArray));

	static Set redbean = new Set("팥", 0);
	static Set cream = new Set("슈크림", 0);
	static Set choco = new Set("초코", 0);
	static Set flour = new Set(0);
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("[MAIN]");
		System.out.println("1. 재료 추가 2. 붕어빵 만들기 3. 붕어빵 판매 4. 수익 확인");
		int select = input.nextInt();
		if (select == 1) {
			add();
		} else if (select == 2) {
			make();
		} else if (select == 3) {
			sell();
		} else if (select == 4) {
			checkEarn();
		} else {
			System.out.println("1, 2, 3, 4번 중에 입력해주세요.");
		}
		end();
	}
	
	static void add() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("[재료 추가]");
		System.out.println("종류: 팥, 슈크림, 초코, 밀가루");
		String ings = input.nextLine();
		
		System.out.println("몇개를 추가하시겠습니까?");
		int num = input.nextInt();
		input.nextLine();
		
		if (ingsList.contains(ings)) {
			if (ings.equals("팥")) {
				redbean.addIngs(num);
			} else if (ings.equals("슈크림")) {
				cream.addIngs(num);
			} else if (ings.equals("초코")) {
				choco.addIngs(num);
			} else if (ings.equals("밀가루")) {
				flour.addFlours(num);
			}
		} else {
			System.out.printf("ERROR : %s 추가 불가능\n", ings);
		}
	}
	
	static void make() {
		Scanner input = new Scanner(System.in);
		
		boolean check = Set.checkFrame("make");
		if (check) {return;}
		
		System.out.println("[붕어빵 만들기]");
		System.out.println("종류: 팥, 슈크림, 초코");
		String ings = input.nextLine();
		
		System.out.println("만들고 싶은 개수는?");
		int num = input.nextInt();
		input.nextLine();
		
		if (ings.equals("팥")) {
			redbean.makeBread(num);
		} else if (ings.equals("슈크림")) {
			cream.makeBread(num);
		} else if (ings.equals("초코")) {
			choco.makeBread(num);
		}
	}
	
	static void sell() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("[붕어빵 판매]");
		boolean check = Set.checkFrame("sell");
		if (check) {return;}
		
		System.out.println("판매할 붕어빵 종류는?");
		String ings = input.nextLine();
		
		System.out.println("판매할 붕어빵 개수는?");
		int num = input.nextInt();
		input.nextLine();
		
		if (ings.equals("팥")) {
			redbean.sellBread(num);
		} else if (ings.equals("슈크림")) {
			cream.sellBread(num);
		} else if (ings.equals("초코")) {
			choco.sellBread(num);
		}
	}
	
	static void checkEarn() {
		System.out.printf("%d원\n", Set.earn);
	}
	
	static void end() {
		System.out.println("-----------------------");
		main(null);
	}
}
