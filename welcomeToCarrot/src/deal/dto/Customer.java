package deal.dto;

public class Customer extends People {
	private String wishBuyThing;
	private int wishBuyPrice;
	
	public Customer(String wishBuyThing, int wishBuyPrice) {
		super();
		this.wishBuyThing = wishBuyThing;
		this.wishBuyPrice = wishBuyPrice;
	}
	
	// ★ extends People 
	public Customer(String id, String residence, String wishBuyThing, int wishBuyPrice) {
		super(id, residence);
		this.wishBuyThing = wishBuyThing;
		this.wishBuyPrice = wishBuyPrice;
	}
	
	// wishBuyThing
	public String getWishBuyThing() {
		return wishBuyThing;
	}
	
	public void setWishBuyThing() {
		this.wishBuyThing = wishBuyThing;
	}
	
	
	// wishBuyPrice
	public int getWishBuyPrice() {
		return wishBuyPrice;
	}
	
	public void setWishBuyPrice() {
		this.wishBuyPrice = wishBuyPrice;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", 구입 희망 가격 :");
		builder.append(wishBuyPrice);
		builder.append("]");
		return builder.toString();
	}
}
