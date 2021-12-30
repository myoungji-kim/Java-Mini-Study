package deal.dto;

public class Seller extends People{
	private String wishSellThing;
	private int wishSellPrice;
	
	public Seller() {}
	public Seller(String wishSellThing, int wishSellPrice) {
		super();
		this.wishSellThing = wishSellThing;
		this.wishSellPrice = wishSellPrice;
	}
	
	// ★ extends People 
	public Seller(String id, String residence, String wishSellThing, int wishSellPrice) {
		super(id, residence);
		this.wishSellThing = wishSellThing;
		this.wishSellPrice = wishSellPrice;
	}
	
	// wishSellThing
	public String getWishSellThing() {
		return wishSellThing;
	}

	public void setWishSellThing(String WishSellThing) {
		this.wishSellThing = wishSellThing;
	}
	
	// wishSellPrice
	public int getWishSellPrice() {
		return wishSellPrice;
	}
	
	public void setWishSellPrice(String WishSellPrice) {
		this.wishSellPrice = wishSellPrice;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", 판매 희망 가격 :");
		builder.append(wishSellPrice);
		builder.append("]");
		return builder.toString();
	}

}
