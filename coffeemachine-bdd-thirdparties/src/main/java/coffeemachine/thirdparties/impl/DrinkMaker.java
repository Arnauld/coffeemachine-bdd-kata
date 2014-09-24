package coffeemachine.thirdparties.impl;

import coffeemachine.thirdparties.IDrinkMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class DrinkMaker implements IDrinkMaker {

    private Pattern drinkPattern = Pattern.compile("^(O::|[CHTP]h?:([12]:0|:))");

    @Override
    public void executeCommand(String command) {
        checkCommand(command);

        Out.infoLn("Execution of command '%1$s'", command);
        prepareDrink(command);
    }

    void prepareDrink(String command) {
        Out.info("Preparing drink ");
        for (int i = 0; i < 10; i++) {
            Out.info(".");
            Processing.process("Sending mail", 1000);
        }
        Out.newLn();
        Out.info("Drink ready...");

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

    @Override
    public List<String> transactionLog() {
        if (txLog == null)
            txLog = new ArrayList<String>();
        return txLog;
    }

    protected void checkCommand(String command) {
        if (command == null)
            throw new IllegalArgumentException("ERR00403012b");

        if (!drinkPattern.matcher(command).matches()) {
            Out.infoLn("Processing command: '%1$s' ...", command);
            Processing.process("Sending mail", 1000);
            Out.infoLn("Command seems to be invalid, asking the knowledge base for further instruction...");
            Processing.process("Sending mail", 2000);
            Out.infoLn("No alternative found");

            throw new IllegalArgumentException("ERR000156987a");
        }
    }
}
