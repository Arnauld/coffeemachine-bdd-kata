package coffeemachine.thirdparties.impl;

import coffeemachine.thirdparties.ICashMachine;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class CashMachine implements ICashMachine {

    private double totalAmountInEuros = 0;

    @Override
    public void insertMoney(double amountInEuros) {
        if (amountInEuros < 0)
            throw new IllegalArgumentException("ERR00034512b");
        totalAmountInEuros += amountInEuros;
    }

    @Override
    public double getMissingMoney(double priceInEuros) {
        if (priceInEuros < 0)
            throw new IllegalArgumentException("ERR00034452b");

        if (priceInEuros > totalAmountInEuros)
            return priceInEuros - totalAmountInEuros;
        else
            return 0;
    }

    @Override
    public void renderMoneyOver(double priceInEuros) {
        if(priceInEuros > totalAmountInEuros)
            throw new IllegalArgumentException("ERR000569852b");

        double moneyToRender = totalAmountInEuros - priceInEuros;
        totalAmountInEuros = 0;
        Out.infoLn("A coin of %1$.2f€ is being forged, wait a bit...", moneyToRender);
        Processing.process("Forging coin", 2000);
        Out.infoLn("Coin forged!");
        Out.infoLn("Coin sent to the \"trappe\"!");
    }

}
