package coffeemachine.thirdparties;

import java.util.regex.Pattern;

import static coffeemachine.thirdparties.Out.*;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class DrinkMaker {

    private Pattern drinkPattern = Pattern.compile("^(M:.+|O::|[CHTP]h?:([12]:0|:))");

    public void executeCommand(String command) {
        checkCommand(command);

        infoLn("Execution of command '%1$s'", command);
        if (command.startsWith("M:")) {
            sendMessage(command);
        } else {
            prepareDrink();
        }
    }

    private void prepareDrink() {
        info("Preparing drink ");
        for (int i = 0; i < 10; i++) {
            info(".");
            waitALittle(1000);
        }
        newLn();
        info("Drink ready...");
    }

    private void sendMessage(String command) {
        infoLn("Sending the message: %1$s", command.substring(2));
        waitALittle(1000);
        infoLn("Message sent: %1$s", command.substring(2));
    }

    protected void checkCommand(String command) {
        if (command == null)
            throw new IllegalArgumentException("ERR00403012b");

        if (!drinkPattern.matcher(command).matches()) {
            infoLn("Processing command: '%1$s' ...", command);
            waitALittle(1000);
            infoLn("Command seems to be invalid, asking the knowledge base for further instruction...");
            waitALittle(2000);
            infoLn("No alternative found");

            throw new IllegalArgumentException("ERR000156987a");
        }
    }

    void waitALittle(int durationInMillis) {
        try {
            Thread.sleep(durationInMillis);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
