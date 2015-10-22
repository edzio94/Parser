package ParserClasses;

/**
 * Created by lukasz on 21.10.15.
 */
public class ParserFactory {
    public static AbstractReader create(String input) {
        if (input.startsWith("http://") || input.startsWith("www"))
            return new WebParser(input);
        return new FileParser(input);

    }

}
