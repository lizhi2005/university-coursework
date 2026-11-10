//package RegexTest;
//
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.io.IOException;
//
//public class QuotesTest {
//    public static void main(String[] args) {
//        try {
//            URL url = new URL("https://quotes.toscrape.com/");
//            URLConnection connection = url.openConnection();
//            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
package RegexTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class QuotesTest {
    public static void main(String[] args) {
        try {
            // 1. 爬取网页
            String url = "https://quotes.toscrape.com/";
            Document doc = Jsoup.connect(url).get();

            // 2. 提取 名言 和 作者
            Elements quotes = doc.select(".text");   // 名言
            Elements authors = doc.select(".author"); // 作者

            // 3. 输出结果
            for (int i = 0; i < quotes.size(); i++) {
                System.out.println("名言：" + quotes.get(i).text());
                System.out.println("作者：" + authors.get(i).text());
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}