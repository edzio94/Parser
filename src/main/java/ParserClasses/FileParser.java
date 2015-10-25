package ParserClasses;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public FileParser(String input) {

        file = new File(input);
        if (!file.exists())
            try {
                throw new FileNotFoundException("File not found!");
            } catch (FileNotFoundException e) {
                System.out.println("File not found !");
                e.printStackTrace();
                System.exit(0);
            }

    }

    public Document read() {
        try {
            doc = Jsoup.parse(file, "UTF-8");
        } catch (IOException e) {
            System.out.println("Parse function cannot be executed!");
            e.printStackTrace();
        }


        return doc;
    }

}

