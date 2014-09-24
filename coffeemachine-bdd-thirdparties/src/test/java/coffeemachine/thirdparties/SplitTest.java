package coffeemachine.thirdparties;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class SplitTest {

    @Test
    public void split() {
        String str = "0::";

        Pattern p = Pattern.compile("(.*):(.*):(.*)");
        Matcher matcher = p.matcher(str);
        assertThat(matcher.matches()).isTrue();

        List<String> split = new ArrayList<String>();
        split.add(matcher.group(1));
        split.add(matcher.group(2));
        split.add(matcher.group(3));

        assertThat(split).containsExactly("0", "", "");
    }
}
