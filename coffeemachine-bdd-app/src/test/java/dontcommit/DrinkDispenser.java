package dontcommit;

import coffeemachine.thirdparties.DrinkMaker;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class DrinkDispenser {
    private final DrinkMaker maker;

    public DrinkDispenser(DrinkMaker maker) {
        this.maker = maker;
    }

    public void takeOrder(Order order) {
        maker.executeCommand(order.toCommand());
    }
}
