package model.domain;

public class GameCharacter {
	private String job;
	private String id;
	private int hp;
	
	public GameCharacter() {}
	
	public GameCharacter(String job, String id, int hp) {
		this.job = job;
		this.id = id;
		this.hp = hp;
	}
	
	// get 메소드
	public String getJob() {
		return job;
	}
	
	public String getId() {
		return id;
	}
	
	public int getHp() {
		return hp;
	}
	
	// set 메소드
	public void setJob(String job) {
		this.job = job;
	}
	
	void setId(String id) {
		this.id = id;
	}
	
	void setHp(int hp) {
		if (hp > 0) {
			this.hp = hp;
		} else {
			System.out.println("체력은 0 이상으로 설정해주세요.");
		}
	}
}
