package ���Ǳ�;
import java.util.Scanner;

public class ManageMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("[�ʱ� ȭ��]");
		System.out.println("��ȣ�� ����ּ���.\n1. ���� �߰� 2. ���� ���� 3. ���� Ȯ�� 4. �Һ��� ���");
		
		int selectMenu = input.nextInt();
		if (selectMenu == 1) {
			add();
		} else if (selectMenu == 2) {
			delete();
		} else if (selectMenu == 3) {
			SetDrinks.checkDrinks();
		} else if (selectMenu == 4) {
			customer();
		}
		end();
	}
	
	static void add() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("[���� �߰�]");
		System.out.println("� ���Ḧ �߰��Ͻðڽ��ϱ�?");
		String name = input.nextLine();
		System.out.println("������ ������ ���Դϱ�?");
		int fee = input.nextInt();
		input.nextLine();
		System.out.println("�� ��� �߰��Ͻðڽ��ϱ�?");
		int num = input.nextInt();
		input.nextLine();
		
		SetDrinks make = new SetDrinks(name, num, fee);
		make.addDrinks();
	}
	
	static void delete() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("[���� ����]");
		System.out.println("� ���Ḧ �����Ͻðڽ��ϱ�?");
		String name = input.nextLine();
		System.out.println("�� ��� �����Ͻðڽ��ϱ�?");
		int num = input.nextInt();
		input.nextLine();
		
		SetDrinks make = new SetDrinks(name, num);
		make.deleteDrinks();
	}
	
	static void customer() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("[�Һ��� ���]");
		System.out.println("���Ǳ⿡ �󸶸� �����ðڽ��ϱ�?");
		int money = input.nextInt();
		input.nextLine();
		
		SetDrinks buy = new SetDrinks(money);
		buy.buyDrinks();
	}
	
	static void end() {
		System.out.println("�۾� �Ϸ�. �ʱ�ȭ������ ���ư��ϴ�.");
		main(null);
	}

}
