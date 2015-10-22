package ParsersClass;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 21.10.15.
 *
 * Class that works with .html files on hard drive
 */
public class FileParser implements AbstractReader {
    Document doc;
    File file;
    Links links;

    public FileParser(String input) {
        this.file = new File(input);
        this.links = new Links();
    }

    public List<String> read() {
        List<String> tempLinks = new ArrayList<String>();
        try {
            doc = Jsoup.parse(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements links = doc.select("a[href]");

        for (Element link : links) {
            if (!link.attr("href").equals("#"))
            tempLinks.add(link.attr("href"));
        }

        return tempLinks;

    }

    public List<String> read(Boolean domainOnly, String URL) {
        return null;
    }

}

