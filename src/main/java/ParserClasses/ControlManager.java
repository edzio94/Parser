package ParserClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lukasz on 22.10.15.
 * Control manager - Controls everything in main window
 */
public class ControlManager {
    public AbstractReader reader;
    HTMLReader htmlReader;
    private Boolean isURL;
    private String URL;
    private Boolean domainOnly;
    private Parser parser;

    public ControlManager(AbstractReader abstractReader) {
        this.reader = abstractReader;
        this.parser = new Parser();

    }

    public void setURL(String URL) {
        this.URL = URL;
        this.isURL = checkIsURL();
    }

    public void mainWork(String URL) {
        List<String> tmp = new ArrayList<String>();
        setURL(URL);
        if (isURL)
            domainOnly = askIfCheckDomainOnly();
        else
            domainOnly = false;
            parser.Parse(reader.read(),this.domainOnly,this.URL);

        if (askToShowLinks()) {
            showLinks();
            while (true) {
                String option = getNumber();
                if (option.equals("Q")) break;
                else {
                    int number = Integer.parseInt(option);
                    htmlReader = new HTMLReader(Links.getlinks().get(number - 1).toString());
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        br.readLine();
                    } catch (IOException e) {
                        System.out.println("Cannot read key!");
                        e.printStackTrace();
                    }
                    showLinks();

                }

            }

        }


    }


    private Boolean checkIsURL() {
        if (this.URL.startsWith("www") || this.URL.startsWith("http://"))
            return true;
        else
            return false;
    }

    private Boolean askIfCheckDomainOnly() {
        Scanner in = new Scanner(System.in);
        System.out.print("Get links only from domain?[Y/N]");
        String decision = in.nextLine();
        if (decision.equals("Y") || decision.equals("y"))
            return true;
        else
            return false;
    }

    private Boolean askToShowLinks() {
        Scanner in = new Scanner(System.in);
        System.out.print("Show links?[Y/N]");
        String decision = in.nextLine();
        if (decision.equals("Y") || decision.equals("y"))
            return true;
        else
            return false;
    }

    private String getNumber() {
        Scanner in = new Scanner(System.in);
        System.out.print("Wanna HTML body of link? Give a number [Q - exit]");
        String decision = in.nextLine();
        return decision;
    }

    private void showLinks() {
        Links.showAllLinks();
    }

}
