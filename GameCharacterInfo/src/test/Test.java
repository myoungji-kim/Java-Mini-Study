package test;

import model.domain.GameCharacter;

public class Test {

	// 캐릭터 만들어서 정보 담아줌
	static GameCharacter[] characterArray() {
		GameCharacter user01 = new GameCharacter("검사", "띵지", 100);
		GameCharacter user02 = new GameCharacter("법사", "법띵", 80);
		GameCharacter[] userList = {user01, user02};
		
		return userList;
	}
	
	// 유저별로 가지고 있는 캐릭터 정보 출력
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
				System.out.printf("%s 님의 직업을 %s 로 변경하였습니다.", id, changeJob);
				break;
			} else {
				System.out.println("일치하는 아이디가 없습니다.");
			}
		}
	}
	
	public static void main(String[] args) {
		GameCharacter[] userList = characterArray();
		printCharacterInfo(userList);
		
		setCharacterJob(userList, "띵지", "궁사");
	}

}
