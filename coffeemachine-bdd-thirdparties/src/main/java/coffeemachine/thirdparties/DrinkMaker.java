package coffeemachine.thirdparties;

import java.util.regex.Pattern;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class DrinkMaker {

    public void executeCommand(String command) {
        checkCommand(command);
    }

    void checkCommand(String command) {
        if (command == null)
            throw new IllegalArgumentException("ERR00403012b");
        if (command.startsWith("M:")) {
            return;
        }

        Pattern drinkPattern = Pattern.compile("(O::|[CHTP]h?:([12]:0|:))");

        if (!drinkPattern.matcher(command).matches()) {
            throw new IllegalArgumentException("ERR08ff3012b");
        }
    }
}
