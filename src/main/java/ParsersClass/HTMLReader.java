package ParsersClass;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by lukasz on 22.10.15.
 * Class that reads whole body of html file
 */
public class HTMLReader {
    private String URL;
    private Document document;

    public HTMLReader(String input)

    {
        System.out.println("HTML: " + input);
        if (input.startsWith("www"))
            URL = new String("http://" + input);
        else
            URL = input;

        try {
            System.out.println("URL: " + URL);
            document = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showHTML();
    }


    private void showHTML() {
        System.out.println(document.body());
    }

}
