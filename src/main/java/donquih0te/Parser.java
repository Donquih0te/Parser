package donquih0te;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {

    private static Changelog changelog;

    public static void main(String[] args) {
        changelog = new Changelog();
        new CurrentChangelogDisplay(changelog);

        startParsing("https://feedback.minecraft.net/knowledgebase/topics/126030-changelogs");
    }

    private static void parse(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("a");
            if(elements.get(4).text().equals("← Knowledge Base")) {
                changelog.setData(elements.get(5).text(), "https://feedback.minecraft.net" + elements.get(5).attr("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startParsing(String url) {
        while(true) {
            parse(url);
        }
    }

}
