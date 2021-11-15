package 자판기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class SetDrinks {
	String name;
	int num;
	int fee;
	int money;
	static ArrayList<String>  names = new ArrayList<>();
	static ArrayList<Integer>  nums = new ArrayList<>();
	static ArrayList<Integer>  fees = new ArrayList<>();

	
	public SetDrinks(int money) {
		this.money = money;
	}
	
	public SetDrinks(String name, int num) {
		this.name = name;
		this.num = num;
	}
	
	public SetDrinks(String name, int num, int fee) {
		this.name = name;
		this.num = num;
		this.fee = fee;
	}


	void addDrinks() {
		if (names.contains(name)) {
			int nameIndex = names.indexOf(name);
			nums.set(nameIndex, nums.get(nameIndex)+num);
		} else {
			names.add(name);
			nums.add(num);
			fees.add(fee);
		}
	}
	
	void deleteDrinks() {
		if (names.contains(name)) {
			int nameIndex = names.indexOf(name);
			if (nums.get(nameIndex)-num > 0) {
				nums.set(nameIndex, nums.get(nameIndex)-num);
				System.out.printf("%d개 제거 완료. 현재 남은 %s 개수: %d개.", num, name, nums.get(nameIndex));
			} else if (nums.get(nameIndex)-num == 0) {
				names.remove(nameIndex);
				nums.remove(nameIndex);
				fees.remove(nameIndex);
				System.out.printf("%s 모두 제거 완료.", name);
			} else if (nums.get(nameIndex)-num < 0) {
				System.out.printf("삭제 가능한 %s 개수: %d개. 명령 실행 불가. 초기화면으로 돌아갑니다.", name, nums.get(nameIndex));
			}
		} else {
			System.out.println("해당 음료는 자판기에 없습니다. 초기 화면으로 돌아갑니다.");
		}
	}
	
	static void checkDrinks() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("[음료 확인]\n");
		System.out.println("확인하실 음료 이름을 입력해주세요.");
		
		String name = input.nextLine();
		if (names.contains(name)) {
			int nameIndex = names.indexOf(name);
			System.out.printf("%s는 %d개 남아있습니다.", name, nums.get(nameIndex));
		} else {
			System.out.printf("%s는 0개 남아있습니다.", name);
		}
	}
	
	void buyDrinks() {
		while (money >= Collections.min(fees)) {
			Scanner input = new Scanner(System.in);
			int count = names.size();
			for (int i = 0; i < count; i++) {
				System.out.printf("%s(%d원), 남은 수량:%d개\n", names.get(i), fees.get(i), nums.get(i));
			}
			System.out.println("--------------------------");
			System.out.println("구매하실 음료 이름을 입력해주세요.");
			String name = input.nextLine();
			if (names.contains(name)) {
				int nameIndex = names.indexOf(name);

				if (nums.get(nameIndex)>=num) {
					if (money >= fees.get(nameIndex)) {
						System.out.println("Case 1");
						System.out.println("몇개를 구매하시겠습니까?");
						int num = input.nextInt();
						input.nextLine();
						
						if (fees.get(nameIndex)*num > money) {
							System.out.printf("%d원이 부족하므로 구매할 수 없습니다.\n", (-1)*(money-fees.get(nameIndex)*num));
							System.out.println("--------------------------");
						} else {
							money -= fees.get(nameIndex)*num;
							System.out.printf("남은 금액은 %d원입니다.\n", money);
							
							nums.set(nameIndex, nums.get(nameIndex)-num);
							 if (nums.get(nameIndex)-num == 0) {
									names.remove(nameIndex);
									nums.remove(nameIndex);
									fees.remove(nameIndex);
							 }
						}
					} else {
						System.out.println("Case 2");
						System.out.printf("%s를 구입하기 위한 최소 금액은 %d원입니다.\n현재 남아있는 %d원으로는 구매할 수 없습니다.\n", name, fees.get(nameIndex), money);
					}
					
				} else {
					System.out.printf("%s는 %d개까지만 구매 가능합니다.\n", name, nums.get(nameIndex));
					System.out.println("--------------------------");
				}
			} else {
				System.out.println("입력하신 메뉴는 자판기에 없습니다.\n");
				System.out.println("--------------------------");
			}
		}
		if (money == 0) {
			System.out.println("모든 구매를 완료하였습니다. 안녕히 가세요.");
		} else if (money < Collections.min(fees)) {
			System.out.println("구입할 수 있는 음료가 없습니다. 안녕히 가세요.");
			System.out.printf("거스름돈: %d원\n", money);
		}
		
	}
	
}
