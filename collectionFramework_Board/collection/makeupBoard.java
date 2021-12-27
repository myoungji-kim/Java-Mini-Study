package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import model.domain.Board;

public class makeupBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("+---------------3-1----------------+");
		HashMap<String, Board> board = new HashMap<String, Board>();
		board.put("NO.1", new Board("제목1", "바보"));
		board.put("NO.2", new Board("제목2", "내용2"));
		board.put("NO.3", new Board("제목3", "내용3"));

		System.out.println(board);
		System.out.println();
		System.out.println("+---------------3-2----------------+");
		if (board.get("NO.1").getText().equals("바보")){
			board.remove("NO.1");
		}
		
		System.out.println(board);
		System.out.println();
		System.out.println("+---------------3-3----------------+");
		Set<String> keySet = board.keySet();
		for (String key : keySet) {
			Board value = board.get(key);
			System.out.println(key + " " + value);
		}
	}

}
