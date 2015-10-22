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
    private Links links;

    public ControlManager(AbstractReader abstractReader) {
        this.reader = abstractReader;
        this.links = new Links();
    }

    public void setURL(String URL) {
        this.URL = URL;
        this.isURL = checkIsURL();
    }

    public void mainWork(String URL) {
        List<String> tmp = new ArrayList<String>();
        setURL(URL);
        if (isURL) {
            domainOnly = checkIfDomain();
            tmp = reader.read(domainOnly, URL);

            saveLinks(tmp);
        } else {
            tmp = reader.read();
            saveLinks(tmp);

        }
        if (checkToShowLinks()) {
            showLinks();
            boolean exit = false;
            while (!exit) {
                String option = getNumber();
                if (option.equals("Q")) {
                    exit = true;
                    break;
                } else {
                    int number = Integer.parseInt(option);
                    htmlReader = new HTMLReader(links.getlinks().get(number - 1).toString());
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        br.readLine();
                    } catch (IOException e) {
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

    private Boolean checkIfDomain() {
        Scanner in = new Scanner(System.in);
        System.out.print("Get links only from domain?[Y/N]");
        String decision = in.nextLine();
        if (decision.equals("Y") || decision.equals("y"))
            return true;
        else
            return false;
    }

    private Boolean checkToShowLinks() {
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
        links.showAllLinks();
    }

    public void saveLinks(List<String> tempLinks) {
        links.setlinks(tempLinks);

    }


}
