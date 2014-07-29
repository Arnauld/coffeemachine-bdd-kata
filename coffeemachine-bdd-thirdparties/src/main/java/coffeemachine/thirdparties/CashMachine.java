package coffeemachine.thirdparties;

import static coffeemachine.thirdparties.Out.infoLn;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class CashMachine {

    private double totalAmountInEuros = 0;

    public void insertMoney(double amountInEuros) {
        if (amountInEuros < 0)
            throw new IllegalArgumentException("ERR00034512b");
        totalAmountInEuros += amountInEuros;
    }

    public double getMissingMoney(double priceInEuros) {
        if (priceInEuros < 0)
            throw new IllegalArgumentException("ERR00034452b");

        if (priceInEuros > totalAmountInEuros)
            return priceInEuros - totalAmountInEuros;
        else
            return 0;
    }

    public void renderMoneyOver(double priceInEuros) {
        if(priceInEuros > totalAmountInEuros)
            throw new IllegalArgumentException("ERR000569852b");

        double moneyToRender = totalAmountInEuros - priceInEuros;
        totalAmountInEuros = 0;
        infoLn("A coin of %1$.2f€ is being forged, wait a bit...", moneyToRender);
        waitALittle(2000);
        infoLn("Coin forged!");
        infoLn("Coin sent to the \"trappe\"!");
    }

    private void waitALittle(int durationInMillis) {
        try {
            Thread.sleep(durationInMillis);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
