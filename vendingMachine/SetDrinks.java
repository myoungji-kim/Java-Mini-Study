package ���Ǳ�;

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
				System.out.printf("%d�� ���� �Ϸ�. ���� ���� %s ����: %d��.", num, name, nums.get(nameIndex));
			} else if (nums.get(nameIndex)-num == 0) {
				names.remove(nameIndex);
				nums.remove(nameIndex);
				fees.remove(nameIndex);
				System.out.printf("%s ��� ���� �Ϸ�.", name);
			} else if (nums.get(nameIndex)-num < 0) {
				System.out.printf("���� ������ %s ����: %d��. ��� ���� �Ұ�. �ʱ�ȭ������ ���ư��ϴ�.", name, nums.get(nameIndex));
			}
		} else {
			System.out.println("�ش� ����� ���Ǳ⿡ �����ϴ�. �ʱ� ȭ������ ���ư��ϴ�.");
		}
	}
	
	static void checkDrinks() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("[���� Ȯ��]\n");
		System.out.println("Ȯ���Ͻ� ���� �̸��� �Է����ּ���.");
		
		String name = input.nextLine();
		if (names.contains(name)) {
			int nameIndex = names.indexOf(name);
			System.out.printf("%s�� %d�� �����ֽ��ϴ�.", name, nums.get(nameIndex));
		} else {
			System.out.printf("%s�� 0�� �����ֽ��ϴ�.", name);
		}
	}
	
	void buyDrinks() {
		while (money >= Collections.min(fees)) {
			Scanner input = new Scanner(System.in);
			int count = names.size();
			for (int i = 0; i < count; i++) {
				System.out.printf("%s(%d��), ���� ����:%d��\n", names.get(i), fees.get(i), nums.get(i));
			}
			System.out.println("--------------------------");
			System.out.println("�����Ͻ� ���� �̸��� �Է����ּ���.");
			String name = input.nextLine();
			if (names.contains(name)) {
				int nameIndex = names.indexOf(name);

				if (nums.get(nameIndex)>=num) {
					if (money >= fees.get(nameIndex)) {
						System.out.println("Case 1");
						System.out.println("��� �����Ͻðڽ��ϱ�?");
						int num = input.nextInt();
						input.nextLine();
						
						if (fees.get(nameIndex)*num > money) {
							System.out.printf("%d���� �����ϹǷ� ������ �� �����ϴ�.\n", (-1)*(money-fees.get(nameIndex)*num));
							System.out.println("--------------------------");
						} else {
							money -= fees.get(nameIndex)*num;
							System.out.printf("���� �ݾ��� %d���Դϴ�.\n", money);
							
							nums.set(nameIndex, nums.get(nameIndex)-num);
							 if (nums.get(nameIndex)-num == 0) {
									names.remove(nameIndex);
									nums.remove(nameIndex);
									fees.remove(nameIndex);
							 }
						}
					} else {
						System.out.println("Case 2");
						System.out.printf("%s�� �����ϱ� ���� �ּ� �ݾ��� %d���Դϴ�.\n���� �����ִ� %d�����δ� ������ �� �����ϴ�.\n", name, fees.get(nameIndex), money);
					}
					
				} else {
					System.out.printf("%s�� %d�������� ���� �����մϴ�.\n", name, nums.get(nameIndex));
					System.out.println("--------------------------");
				}
			} else {
				System.out.println("�Է��Ͻ� �޴��� ���Ǳ⿡ �����ϴ�.\n");
				System.out.println("--------------------------");
			}
		}
		if (money == 0) {
			System.out.println("��� ���Ÿ� �Ϸ��Ͽ����ϴ�. �ȳ��� ������.");
		} else if (money < Collections.min(fees)) {
			System.out.println("������ �� �ִ� ���ᰡ �����ϴ�. �ȳ��� ������.");
			System.out.printf("�Ž�����: %d��\n", money);
		}
		
	}
	
}
