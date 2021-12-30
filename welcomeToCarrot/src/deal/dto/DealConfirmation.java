package deal.dto;

public class DealConfirmation {
	private int idx; 			// 거래 활동 고유 번호
	private String title;		// 거래 활동 제목 == 거래 물건 이름
	private String state;		// 거래 진행 상태
	private Seller seller;		// 판매자
	private Customer customer;	// 소비자
	
	
	public DealConfirmation() {}
	public DealConfirmation(int idx, String title, String state, Seller seller, Customer customer) {
		this.idx = idx;
		this.title = title;
		this.state = state;
		this.seller = seller;
		this.customer = customer;
	}

	
	// idx
	public int getIdx() {
		return idx;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	// title
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	// seller
	public Seller getSeller() {
		return seller;
	}
	
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	// customer
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	// state
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [IDX: ");
		builder.append(idx);
		builder.append(", Title: ");
		builder.append(title);
		builder.append(", State: ");
		builder.append(state);
		builder.append(",\r\n 판매자 정보: ");
		builder.append(seller);
		builder.append(",\r\n 소비자 정보: ");
		builder.append(customer);
		builder.append("]");
		return builder.toString();
	}
}
