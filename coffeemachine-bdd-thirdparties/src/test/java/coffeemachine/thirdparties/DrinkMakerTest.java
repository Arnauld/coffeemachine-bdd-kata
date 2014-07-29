package coffeemachine.thirdparties;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class DrinkMakerTest {

    @Test
    @Parameters({
            "O::",
            "T::",
            "P::",
            "C::",
            "H::",
            "H:1:0",
            "H:2:0",
            "C:1:0",
            "C:2:0",
            "P:1:0",
            "P:2:0"
    })
    public void valid_command_should_not_throw_any_exception(String command) {
        new DrinkMaker() {
            @Override
            void waitALittle(int durationInMillis) {
            }
        }.checkCommand(command);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({
            "Oh::",
            "Oh:1:0",
            "O:1:0",
            "::",
            "C:1",
            "C12",
            "BOOM",
            "C:3:0",
            "C:1:1"
    })
    public void invalid_command_should_throw_an_exception(String command) {
        new DrinkMaker() {
            @Override
            void waitALittle(int durationInMillis) {
            }
        }.checkCommand(command);
    }
}
