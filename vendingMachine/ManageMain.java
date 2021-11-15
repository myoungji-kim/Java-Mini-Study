package 자판기;
import java.util.Scanner;

public class ManageMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("[초기 화면]");
		System.out.println("번호를 골라주세요.\n1. 음료 추가 2. 음료 삭제 3. 음료 확인 4. 소비자 모드");
		
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
		
		System.out.println("[음료 추가]");
		System.out.println("어떤 음료를 추가하시겠습니까?");
		String name = input.nextLine();
		System.out.println("음료의 가격은 얼마입니까?");
		int fee = input.nextInt();
		input.nextLine();
		System.out.println("총 몇개를 추가하시겠습니까?");
		int num = input.nextInt();
		input.nextLine();
		
		SetDrinks make = new SetDrinks(name, num, fee);
		make.addDrinks();
	}
	
	static void delete() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("[음료 삭제]");
		System.out.println("어떤 음료를 제거하시겠습니까?");
		String name = input.nextLine();
		System.out.println("총 몇개를 제거하시겠습니까?");
		int num = input.nextInt();
		input.nextLine();
		
		SetDrinks make = new SetDrinks(name, num);
		make.deleteDrinks();
	}
	
	static void customer() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("[소비자 모드]");
		System.out.println("자판기에 얼마를 넣으시겠습니까?");
		int money = input.nextInt();
		input.nextLine();
		
		SetDrinks buy = new SetDrinks(money);
		buy.buyDrinks();
	}
	
	static void end() {
		System.out.println("작업 완료. 초기화면으로 돌아갑니다.");
		main(null);
	}

}
