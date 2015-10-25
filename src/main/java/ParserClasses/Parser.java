package ParserClasses;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 25.10.15.
 */
public class Parser {
    Document doc;


    public void Parse(Document doc,Boolean domainOnly,String input)
    {
        List<String> tempLinks = new ArrayList<String>();
        this.doc = doc;
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            if (domainOnly && link.attr("href").contains(input) && !link.attr("href").equals("#")) {
                tempLinks.add(link.attr("href"));
            } else if (!domainOnly && !link.attr("href").equals("#")) {
                tempLinks.add(link.attr("href"));
            }
        }

        Links.setlinks(tempLinks);

    }

}
