package coffeemachine.thirdparties;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public interface ICashMachine {
    void insertMoney(double amountInEuros);

    double getMissingMoney(double priceInEuros);

    void renderMoneyOver(double priceInEuros);
}
