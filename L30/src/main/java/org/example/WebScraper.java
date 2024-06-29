package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper {

    public static void main(String[] args) {
//        String url = "https://ru.wikipedia.org/wiki/%D0%92%D0%BE%D0%B4%D0%B0"; // Замість цього URL використайте реальний сайт, який хочете скрапити

        String url = "http://localhost:8080/number";

        try {
            // Завантажуємо HTML-документ з URL
            Document doc = Jsoup.connect(url).get();

            // Витягуємо заголовки (припустимо, це заголовки &lt;h1&gt;)
            Elements headings = doc.select("h1");

            // Виводимо знайдені заголовки
            for (Element heading : headings) {
                System.out.println(heading.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}