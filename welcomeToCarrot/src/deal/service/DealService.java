package deal.service;

import deal.dao.DealDAO;
import deal.dto.Customer;
import deal.dto.DealConfirmation;

import java.util.ArrayList;

import deal.controller.DealController;

public class DealService {
	private static DealService instance = new DealService();
	private DealDAO dealDAO = DealDAO.getInstance();
	
	public static DealService getInstance() {
		return instance;
	}
	
	// selectList
	public ArrayList<DealConfirmation> getAllDeals() {
		return dealDAO.getAllDeals();
	}
	
	// selectOne
	public DealConfirmation getDeal(String thingName){
		DealConfirmation deal = null;
		ArrayList<DealConfirmation> deals = dealDAO.getAllDeals();
		for (int i=0; i < deals.size(); i++) {
			if (deals.get(i).getTitle().equals(thingName)) {
				deal = deals.get(i);
			}
		}
		return deal;
	}
	
	
	// insert
	public void insertDeal(DealConfirmation newDeal) {
		dealDAO.insertDeal(newDeal);
	}
	
	// update
	public void updateDeal(DealConfirmation deal, Customer customer) {
		dealDAO.updateDeal(deal, customer);
	}
	
	// delete
	public void deleteDeal() {
		ArrayList<DealConfirmation> deals = dealDAO.getAllDeals();
		for (int i=0; i < deals.size(); i++) {
			if (deals.get(i).getState().equals("거래 완료")) {
				dealDAO.deleteDeal(deals.get(i));
			}
		}
	}
}
