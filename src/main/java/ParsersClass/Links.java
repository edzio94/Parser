package ParsersClass;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lukasz on 22.10.15.
 */

public class Links {

    private List<String> links;


    public Links() {
        links = new ArrayList<String>();
    }

    protected void showAllLinks() {
        int i = 0;
        for (String link : links) {
            ++i;

            System.out.println(i + "." + link);
        }
    }

    public List<String> getlinks() {
        return links;
    }

    public void setlinks(List<String> linksfromURL) {
        for (String q : linksfromURL) {
            this.links.add(q);
        }
    }

}
