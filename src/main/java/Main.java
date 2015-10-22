import java.util.Scanner;

import ParserClasses.ParserFactory;
import ParserClasses.*;

/**
 * Created by lukasz on 21.10.15.
 */
public class Main {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        System.out.println("Give link to parse: ");
        String input;
        input = in.nextLine();

        new ControlManager(ParserFactory.create(input)).mainWork(input);



    }

}
