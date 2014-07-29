package coffeemachine.thirdparties;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class StringFormatTest {

    @Test
    public void usecase() {
        assertThat(String.format("Hello %1$s", "John")).isEqualTo("Hello John");
    }
}
