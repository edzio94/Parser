package ParserClasses;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by lukasz on 21.10.15.
 */
public class WebReader implements AbstractReader {

    private String input;
    public Document doc;
    private Links links;


    public WebReader(String input) {
        if(input.startsWith("www"))
            this.input = new String("http://"+input);
        else
            this.input = input;

    }

    public Document read() {
            try {
                doc = Jsoup.connect(input).get();
            } catch (IOException e) {

                System.out.println("Cannot read URL input!");
                e.printStackTrace();
            }

        return doc;
    }





}
