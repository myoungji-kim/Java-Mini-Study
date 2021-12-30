package deal.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import deal.controller.DealController;
import deal.dto.Customer;
import deal.dto.DealConfirmation;
import deal.dto.Seller;
import deal.exception.NotExistException;

public class StartView {
	public static void main(String[] args) throws NotExistException {
		Scanner scan = new Scanner(System.in);
		DealController controller = DealController.getInstance();
		boolean isExit = false;
		int idx = 1;
		
		while (!isExit) {
			System.out.println();
			System.out.println("+------------ 웰컴 투 당근 ------------+");
			System.out.println("<< 원하는 메뉴를 선택해주세요. (번호 입력) >>");
			System.out.println("1. 전체 거래 목록 확인 \r\n2. 판매할 물건 등록\r\n3. 거래 요청\r\n4. 거래 완료 목록 삭제");
			System.out.println("+------------------------------------+");
			String option = scan.nextLine();
			
			// 전체 거래 목록 확인
			if (option.equals("1")) {
				controller.getAllDeals();
			// 판매할 물건 등록
			} else if (option.equals("2")) {
				System.out.println("+------------ 2. 판매할 물건 등록 ------------+");
				System.out.println("판매자의 정보를 입력해주세요(아이디, 거주지) ");
				String id = scan.nextLine();
				String residence = scan.nextLine();
				
				System.out.println("+--------------------------------------------+");
				System.out.println("판매를 원하는 물품에 대한 정보를 입력해주세요. (물품 이름, 판매 희망 가격) ");
				String thingName = scan.nextLine();
				int wishSellPrice = scan.nextInt();
				scan.nextLine();
				System.out.println("+--------------------------------------------+");
				
				Seller seller = new Seller(id, residence, thingName, wishSellPrice);
				Customer customer = new Customer("(미정)", "(미정)", "(미정)", 0);
				DealConfirmation confirmation = new DealConfirmation(idx++, thingName, "거래 미완료", seller, customer);
				controller.insertDeal(confirmation);

			// 거래 요청
			} else if (option.equals("3")) {
				System.out.println("+------------ 3. 거래 요청 ------------+");
				if (controller.checkCanDeal()) {
					System.out.println("  본인의 정보를 입력해주세요. (아이디, 거주지) ");
					String id = scan.nextLine();
					String residence = scan.nextLine();
					
					// 구매 희망 ""물품"" 이름 입력 및 가능 여부 체크
					System.out.println("+--------------------------------------------+");
					System.out.println("구매를 원하는 물품 이름을 입력해주세요.");
					String thingName = scan.nextLine();
					DealConfirmation deal = controller.findThingName(thingName);
					if (deal != null) {
						// 구매 희망 ""가격"" 입력 및 가능 여부 체크
						System.out.println("+--------------------------------------------+");
						System.out.println("구매를 원하는 가격을 입력해주세요.");
						try {
							int wishBuyPrice = scan.nextInt();
							scan.nextLine();
							if (controller.compareWishPrice(deal, wishBuyPrice)) {
								Customer customer = new Customer(id, residence, thingName, wishBuyPrice);
								controller.updateDeal(deal, customer);
							}
						} catch (InputMismatchException e) {
							// 입력값 형식에 대한 예외처리
							FailView.failMessageView("입력하신 데이터의 형태를 확인해주세요(예외처리완료)"); 
						}
					}
				}
				
			// 거래 완료 목록 삭제
			} else if (option.equals("4")) {
				controller.deleteDeal();
				
			// 시스템 종료
			} else if (option.equals("5")) {
				System.out.println("Info : 시스템을 종료합니다");
				isExit = true;
			} else {
				System.out.println("Info : 1 ~ 5번 중에 선택해주세요");
				
			}
			
		}
	}
}
