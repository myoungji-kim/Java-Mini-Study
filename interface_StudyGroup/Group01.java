package interfaces;

public class Group01 extends StudyGroup implements Attendance, Announcement {

	@Override
	public void selectMember() {
		// TODO Auto-generated method stub
		System.out.println("발표할 학생을 선택합니다.");
	}

	@Override
	public void startAnnouncement() {
		// TODO Auto-generated method stub
		System.out.println("발표를 시작합니다.");
	}

	@Override
	public void giveFeedback() {
		// TODO Auto-generated method stub
		System.out.println("발표에 대한 피드백을 시작합니다.");
	}

	@Override
	public void attendaceCheck() {
		// TODO Auto-generated method stub
		System.out.println("출석 체크하겠습니다!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Group01 group01 = new Group01();
		group01.attendaceCheck();
		group01.selectMember();
		group01.startAnnouncement();
		group01.giveFeedback();
	}

}
