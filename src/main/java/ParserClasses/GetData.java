package ParserClasses;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.Scanner;

/**
 * Created by lukasz on 26.10.15.
 */
public class GetData {

    public Boolean checkIsURL(String input) {
        return (input.startsWith("www") ||
                input.startsWith("http://"));
    }

    public String getNumber() {
        Scanner in = new Scanner(System.in);
        System.out.print("Wanna HTML body of link? Give a number [Q - exit]");
        return in.nextLine();
    }

    public Boolean checkDecision(String question) {
        Scanner in = new Scanner(System.in);
        System.out.println(question);
        String decision = in.nextLine();
        return (decision.equals("Y") | decision.equals("y"));
    }

}
