package deal.controller;

import java.util.ArrayList;

import deal.dto.Customer;
import deal.dto.DealConfirmation;
import deal.exception.NotExistException;
import deal.service.DealService;
import deal.view.EndView;
import deal.view.FailView;


public class DealController {
	// 기본 셋팅
	private static DealController instance = new DealController();
	private DealService service = DealService.getInstance();
	
	private DealController() {}
	
	public static DealController getInstance() {
		return instance;
	}

	// 1 - 전체 거래 목록 확인
	public void getAllDeals() {
		ArrayList<DealConfirmation> deals = service.getAllDeals();
		if (deals.size() == 0) {
			EndView.showMessage("Info : 현재 진행 중인 거래 목록이 없습니다");
		} else {
			EndView.getAllDeals(deals);
		}
	}
	
	// 2 - 판매할 물건 등록
	public void insertDeal(DealConfirmation newDeal) {
		service.insertDeal(newDeal);
	}
	
	// 3 - 거래 요청
	// // 거래 가능한지 체크
	public boolean checkCanDeal() {
		ArrayList<DealConfirmation> deals = service.getAllDeals();
		if (deals.size() == 0) {
			EndView.showMessage("Info : 현재 진행 중인 거래 목록이 없습니다");
			return false;
		} else {
			return true;
		}
	}
	
	// // 해당 물건 있는지 체크
	public DealConfirmation findThingName(String thingName) {
		DealConfirmation deal = service.getDeal(thingName);
		if (deal == null) {
			EndView.showMessage("Info : 해당 물품은 아직 올라오지 않았습니다.");
		} 
		return deal;
	}
	
	// // 가격 비교해서 구매 가능한지 체크
	public boolean compareWishPrice(DealConfirmation deal, int wishBuyPrice) {
		if(deal.getSeller().getWishSellPrice() <= wishBuyPrice) {
			EndView.showMessage("Info : 구매 가능합니다. 구매자 정보가 업데이트 되었습니다.");
			return true;
		} else {
			EndView.showMessage("Info : 구매 희망 가격이 판매 희망 가격보다 적습니다.");
			return false;
		}
	}
	
	public void updateDeal(DealConfirmation deal, Customer customer) throws NotExistException{
		service.updateDeal(deal, customer);
	}
	
	// 4 - 거래 완료 목록 삭제
	public void deleteDeal(){
		service.deleteDeal();
		EndView.showMessage("Info : 거래가 완료된 모든 목록을 삭제했습니다.");
	}
}
