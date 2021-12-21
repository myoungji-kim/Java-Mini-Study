package test;

import model.domain.GameCharacter;

public class Test {

	// ĳ���� ���� ���� �����
	static GameCharacter[] characterArray() {
		GameCharacter user01 = new GameCharacter("�˻�", "����", 100);
		GameCharacter user02 = new GameCharacter("����", "����", 80);
		GameCharacter[] userList = {user01, user02};
		
		return userList;
	}
	
	// �������� ������ �ִ� ĳ���� ���� ���
	static void printCharacterInfo(GameCharacter[] userList) {
		for(GameCharacter user : userList) {
			System.out.println(user.getJob());
			System.out.println(user.getId());
			System.out.println(user.getHp());
		}
	}
	
	static void setCharacterJob(GameCharacter[] userList, String id ,String changeJob) {
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getId() == id) {
				userList[i].setJob(changeJob);
				System.out.printf("%s ���� ������ %s �� �����Ͽ����ϴ�.", id, changeJob);
				break;
			} else {
				System.out.println("��ġ�ϴ� ���̵� �����ϴ�.");
			}
		}
	}
	
	public static void main(String[] args) {
		GameCharacter[] userList = characterArray();
		printCharacterInfo(userList);
		
		setCharacterJob(userList, "����", "�û�");
	}

}
