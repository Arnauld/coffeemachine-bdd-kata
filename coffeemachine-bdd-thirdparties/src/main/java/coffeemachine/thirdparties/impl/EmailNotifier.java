package coffeemachine.thirdparties.impl;

import coffeemachine.thirdparties.IEmailNotifier;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class EmailNotifier implements IEmailNotifier {

    @Override
    public void notifyMissingDrink(String drink) {
        Out.infoLn("Sending mail. Missing drink: '%1$s'", drink);
        Processing.process("Sending mail", 2000);
        Out.infoLn("Mail sent");

    }

    @Override
    public void notifyDrinkReport(String report) {
        Out.infoLn("Sending mail. Report: '%1$s'", report);
        Processing.process("Sending mail", 2000);
        Out.infoLn("Mail sent");
    }
}
