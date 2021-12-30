package deal.dto;

public class People {
	private String id; 			// 아이디
	private String residence;	// 거주지
	
	public People() {}
	public People(String id, String residence) {
		super();
		this.id = id;
		this.residence = residence;
	}
	
	public String getId() {
		return id;
	}
	
	public String getResidence() {
		return residence;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[아이디 : ");
		builder.append(id);
		builder.append(", 거주지 : ");
		builder.append(residence);
		return builder.toString();
	}
}
