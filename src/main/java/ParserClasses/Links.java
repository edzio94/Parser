package ParserClasses;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lukasz on 22.10.15.
 */

public final class Links {

    private static List<String> links;


    private Links() {
        links = new ArrayList<String>();
    }

    public static List<String> getlinks() {
        return links;
    }

    public static void setlinks(List<String> linksfromURL) {
        links = new ArrayList<>();
        links = linksfromURL;

    }

}
