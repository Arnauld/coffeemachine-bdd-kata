package coffeemachine.thirdparties;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
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
            prepareDrink(command);
        }
    }

    void prepareDrink(String command) {
        info("Preparing drink ");
        for (int i = 0; i < 10; i++) {
            info(".");
            waitALittle(1000);
        }
        newLn();
        info("Drink ready...");

        //
        transactionLog().add(decodeDrink(command));
    }

    private String decodeDrink(String command) {
        StringBuilder b = new StringBuilder();

        Pattern p = Pattern.compile("(.*):(.*):(.*)");
        Matcher matcher = p.matcher(command);
        if(!matcher.matches())
            throw new IllegalArgumentException("Invalid command");

        String drinkType = matcher.group(1);
        String nbSugars = matcher.group(2);

        if (drinkType.startsWith("C")) {
            b.append("Coffee");
        } else if (drinkType.startsWith("H")) {
            b.append("Chocolate");
        } else if (drinkType.startsWith("O")) {
            b.append("Orange juice");
        } else if (drinkType.startsWith("T")) {
            b.append("Tea");
        } else if (drinkType.startsWith("P")) {
            b.append("Tomato potage");
        }

        b.append(";");
        if (drinkType.endsWith("h"))
            b.append("extra hot");
        else
            b.append("normal");

        b.append(";");
        if (nbSugars.equals("1"))
            b.append("1").append(";stick");
        else if (nbSugars.equals("2"))
            b.append("2").append(";stick");
        else
            b.append("0").append(";no-stick");

        return b.toString();
    }

    private List<String> txLog;

    public List<String> transactionLog() {
        if (txLog == null)
            txLog = new ArrayList<String>();
        return txLog;
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
