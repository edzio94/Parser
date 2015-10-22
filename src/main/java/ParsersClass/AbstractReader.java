package ParsersClass;

import java.util.List;

/**
 * Created by lukasz on 21.10.15.
 */
public interface AbstractReader {
    List<String> read();

    List<String> read(Boolean domainOnly, String URL);

}
