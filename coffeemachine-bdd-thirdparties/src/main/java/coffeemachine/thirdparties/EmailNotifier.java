package coffeemachine.thirdparties;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class EmailNotifier {
    public void notifyMissingDrink(String drink) {
        Out.infoLn("Sending mail. Missing drink: '%1$s'", drink);
    }

    public void notifyDrinkReport(String report) {
        Out.infoLn("Sending mail. Report: '%1$s'", report);
    }
}
