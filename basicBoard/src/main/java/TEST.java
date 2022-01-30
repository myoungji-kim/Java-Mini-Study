//import java.util.Arrays;
//import java.util.Collections;
//
//import com.ddingji.board.dto.SetFileName;
//
//public class TEST {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String[] fileNames = {"테스트(2).jpg", "테스트(3).jpg"};
//		Arrays.sort(fileNames, Collections.reverseOrder());
////		for (int i = 0; i < fileNames.length; i++) {
////			System.out.println(fileNames[i]);
////		}
//		
//		String fileNameOrig = "테스트.jpg";
//		
//		// New 파일명 분리하기
//		String extension_n = fileNameOrig.substring(fileNameOrig.lastIndexOf("."));
//		System.out.println("extension_n: "+extension_n);
//		String tempFileName_n = fileNameOrig.substring(0, fileNameOrig.length()-extension_n.length());
//		System.out.println("tempFileName_n: "+tempFileName_n);
//		boolean isChange = false;
//		
//		// 중복 파일명 있는지 검사
//		for (int i = 0; i < fileNames.length; i++) {
//			if (fileNames[i].contains(tempFileName_n)) {
//				// Original
//				// 1 확장자만
//				String extension_o = fileNames[i].substring(fileNames[i].lastIndexOf("."));
//				System.out.println("1. extension_o: "+extension_o);
//				// 2 확장자 제외 파일명 (넘버 포함)
//				String tempFileFullName_o = fileNames[i].substring(0, fileNames[i].length()-extension_o.length());
//				System.out.println("2. tempFileFullName_o: "+tempFileFullName_o);
//				// 3 괄호 + 넘버
//				String numBox_o = tempFileFullName_o.substring(tempFileFullName_o.lastIndexOf("("));
//				System.out.println("3. numBox_o: "+numBox_o);
//				// 4 확장자&넘버 제외 순수 파일명
//				String tempFileName_o = fileNames[i].substring(0, fileNames[i].length()-(extension_o.length()+numBox_o.length()));
//				System.out.println("4. tempFileName_o: "+tempFileName_o);
//				
//				System.out.println("//////////////////////");
//				// + 우에에엑 ㅠ
//				if (tempFileName_o.equals(tempFileName_n)) { 
//					// 5 넘버
//					String num_o = numBox_o.substring(1, numBox_o.length()-1);
//					System.out.println("5. num_o: "+num_o);
//					SetFileName u = new SetFileName();
//					if (u.isNumeric(num_o)) {
//						int num = Integer.parseInt(num_o);
//						num++;
//						String num_n = Integer.toString(num);
//						fileNameOrig = tempFileName_n + "(" + num_n + ")";
//						isChange = true;
//					}
//				}
//				break;
//			}
//		}
//		
//		if (!isChange) {
//			fileNameOrig = tempFileName_n + "(1)" + extension_n;
//		}
//		
//		System.out.println("result: "+fileNameOrig);
//	}
//
//}
