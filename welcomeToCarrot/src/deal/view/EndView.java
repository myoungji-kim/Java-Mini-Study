package deal.view;

import java.util.ArrayList;

import deal.dto.DealConfirmation;


public class EndView {
	
	// 모든 프로젝트 출력
	public static void getAllDeals(ArrayList<DealConfirmation> allDeals) {
		for(int i = 0; i < allDeals.size(); i++) {
			System.out.println("[NO." + (i+1) + "]");
			System.out.println(allDeals.get(i) + "\n");
		}
	}
	
	// 예외가 아닌 단순 메세지 출력
	public static void showMessage(String message) {
		System.out.println(message);
	}
}
