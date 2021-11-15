package makeFishBread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Set {
	static int frameNum = 8;
	static int frameUseNum;
	static int flourNum;
	static int fee = 1000;
	static int earn;
	//
	static String[] ingsArray = {"ÆÏ", "½´Å©¸²", "ÃÊÄÚ", "¹Ð°¡·ç"};
	static ArrayList<String>  ingsList = new ArrayList<>(Arrays.asList(ingsArray));
	//
	String ings;
	int ingsNum;
	int breadNum;

	public Set(int num) {
		this.ingsNum = num;
	}
	
	public Set(String ings, int ingsNum) {
		this.ings = ings;
		this.ingsNum = ingsNum;
		this.breadNum = ingsNum;
	}
	
	void addFlours(int num) {
		flourNum += num;
	}
	
	void addIngs(int addNum){
		this.ingsNum += addNum;
	}
	
	static boolean checkFrame(String select) {
		if (select.equals("make")) {
			if (frameNum == frameUseNum) {
				System.out.println("ERROR : Ä­ ºÎÁ·");
				return true;
			} else if (flourNum == 0) {
				System.out.println("ERROR : ¹Ð°¡·ç ºÎÁ·");
				return true;
			}
		} else if (select.equals("sell")) {
			if (frameUseNum == 0) {
				System.out.println("ERROR : ¸¸µé¾îµÐ ºØ¾î»§ 0°³\n");
				return true;
			}
		}
		return false;
	}
	
	void makeBread(int addNum) {
		if (frameNum < frameUseNum + addNum) {
			System.out.printf("ERROR : ÇöÀç »ç¿ë °¡´ÉÇÑ ºØ¾î»§ Æ² - %d°³\n", frameNum - frameUseNum);
		} else if (addNum > flourNum) {
			System.out.println("ERROR : ¹Ð°¡·ç ºÎÁ·\n");
		} else {
			if (this.ingsNum - addNum < 0) {
				System.out.printf("ERROR : Àç·á ºÎÁ· (ÇöÀç %sÀº %d°³ ÀÖÀ½)", this.ings, this.ingsNum);
			} else {
				this.ingsNum -= addNum;
				this.breadNum += addNum;
				
				flourNum -= addNum;
				frameUseNum += addNum;
			}
		}
	}
	
	void sellBread(int num) {
		this.breadNum = selling(this.ings, num, this.breadNum);
	}
	
	int selling(String ings, int sellNum, int BreadNum) {
		if (BreadNum == 0 || sellNum > BreadNum) {
			System.out.printf("ERROR : ¸¸µé¾îµÐ %s¸À ºØ¾î»§ - %d°³\n", ings, BreadNum);
		} else {
			System.out.printf("ÆÇ¸ÅÇÑ %s¸À ºØ¾î»§ - %d°³", ings, sellNum);
			BreadNum -= sellNum;
			frameUseNum -= sellNum;
			earn += fee * sellNum;
		}
		return BreadNum;
	}
}
