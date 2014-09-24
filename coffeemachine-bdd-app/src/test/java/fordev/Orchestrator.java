package fordev;

import coffeemachine.thirdparties.DrinkMaker;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Orchestrator {

    private final DrinkMaker drinkMaker;

    public Orchestrator(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void takeOrder(Order order) {
        String command = new Protocol().toCommand(order);
        drinkMaker.executeCommand(command);
    }
}
