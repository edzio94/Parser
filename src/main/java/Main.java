import java.util.Scanner;
import java.io.Console;
import java.io.IOException;

import ParsersClass.*;
import sun.plugin.navig.motif.Worker;

import static java.lang.System.out;

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
