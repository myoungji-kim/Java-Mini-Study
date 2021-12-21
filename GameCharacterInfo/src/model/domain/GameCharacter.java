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
	
	// get �޼ҵ�
	public String getJob() {
		return job;
	}
	
	public String getId() {
		return id;
	}
	
	public int getHp() {
		return hp;
	}
	
	// set �޼ҵ�
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
			System.out.println("ü���� 0 �̻����� �������ּ���.");
		}
	}
}
