package coffeemachine.thirdparties;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public interface IEmailNotifier {
    void notifyMissingDrink(String drink);

    void notifyDrinkReport(String report);
}
