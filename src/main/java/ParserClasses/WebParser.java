package ParserClasses;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 21.10.15.
 */
public class WebParser implements AbstractReader {

    private String input;
    private Document doc;


    public WebParser(String input) {
        this.input = input;

    }

    public List<String> read() {
        return null;
    }

    ;

    public List<String> read(Boolean domainOnly, String input) {
        List<String> tempLinks = new ArrayList<String>();
        if (input.startsWith("www")) {
            try {
                doc = Jsoup.connect("http://" + input).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                doc = Jsoup.connect(input).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //System.out.println(doc.body());
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            if (domainOnly && link.attr("href").contains(input) && !link.attr("href").equals("#")) {
                tempLinks.add(link.attr("href"));
            } else if (!domainOnly && !link.attr("href").equals("#")) {
                tempLinks.add(link.attr("href"));
            }
        }
        return (tempLinks);
    }


}
