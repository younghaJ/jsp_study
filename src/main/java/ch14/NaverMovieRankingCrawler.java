package ch14;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverMovieRankingCrawler {
  public static void main(String[] args) {
    try {
      // Send HTTP request to Naver movie ranking URL
      Document doc = Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.naver").get();
      
      // Extract movie titles from parsed HTML using CSS selector
      Elements movieTitles = doc.select("div.tit5 > a");
      
      // Print the movie titles
      for (Element title : movieTitles) {
        System.out.println(title.text());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}