package dontcommit;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        tags = {"@end-to-end"},
        glue = {"dontcommit.share", "dontcommit.endtoend"})
public class RunnerEndToEndTest {
}
