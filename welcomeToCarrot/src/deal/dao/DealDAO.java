package deal.dao;

import java.util.ArrayList;

import deal.dto.Customer;
import deal.dto.DealConfirmation;
import deal.dto.Seller;

public class DealDAO {
	private static DealDAO instance = new DealDAO();
	private ArrayList<DealConfirmation> dealDAO = new ArrayList<>();
	
	private DealDAO() {	}
	
	public static DealDAO getInstance() {
		return instance;
	}
	
	public ArrayList<DealConfirmation> getAllDeals(){
		return dealDAO;
	}
	
	private static int idx = 0;
	public void insertDeal(DealConfirmation newDeal) {
		dealDAO.add(newDeal);
	}

	public void updateDeal(DealConfirmation deal, Customer customer) {
		deal.setState("거래 완료");
		deal.setCustomer(customer);
	}
	
	public void deleteDeal(DealConfirmation deal) {
		dealDAO.remove(deal);
	}
}
