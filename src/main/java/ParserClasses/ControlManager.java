package ParserClasses;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by lukasz on 22.10.15.
 * Control manager - Controls everything in main window
 */
public class ControlManager {
    public AbstractReader reader;
    private Parser parser;
    private DataHolder dataHolder;
    private GetData getData;

    public ControlManager(AbstractReader abstractReader) {
        this.reader = abstractReader;
        this.parser = new Parser();
        this.dataHolder = new DataHolder();
        this.getData = new GetData();

    }


    public void mainWork(String URL) {
        setURL(URL);
        if (getData.getIsURL())
            this.dataHolder.setDomainOnly(this.getData.checkDecision("Do you want see link from domain only?[Y/N]"));
        else
            this.dataHolder.setDomainOnly(false);
        this.dataHolder.setInput(URL);

        parser.Parse(reader.read(), this.dataHolder.getDomainOnly(), this.dataHolder.getInput());

        if (this.getData.checkDecision("Show links?[Y/N]")) {
            showLinks();
            while (true) {
                this.getData.setLinkOption(getData.getNumber());
                if (this.getData.getLinkOption().equals("Q")) break;
                else {
                    int number = Integer.parseInt(this.getData.getLinkOption());
                    this.dataHolder.setInput(Links.getlinks().get(number - 1));
                    WebReader webReader = new WebReader(this.dataHolder.getInput());
                    System.out.println(webReader.read());
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


    public void setURL(String URL) {
        this.dataHolder.setInput(URL);
        this.getData.setIsURL(this.getData.checkIsURL(URL));
    }


    private void showLinks() {

        final int[] i = {0};
        Links.getlinks().stream().forEach(link -> System.out.println((++i[0]) + "." + link));
    }

}
