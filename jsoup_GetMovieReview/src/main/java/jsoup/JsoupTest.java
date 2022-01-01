package jsoup;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.domain.Content;

public class JsoupTest {
	public static void main(String[] args) {
		// URL 가져오기
		Document doc = null;
		System.out.println("영화 [고장난 론] 네이버 평점");
		for (int i = 1; i < 11; i++) {
		    try {
		        doc = Jsoup.connect("https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver?code=209496&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page="+ i).get();
		        System.out.println("[Page: "+i+"]");
		        for (int j = 0; j < 11; j++) {
		            Elements contents = doc.select("#_filtered_ment_" + j);
		            for (Element content : contents) {
		                System.out.println("댓글"+(j+1)+": "+content.text());
		            }
		        }
		        System.out.println();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}
}
