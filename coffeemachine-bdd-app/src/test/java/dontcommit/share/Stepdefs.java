package dontcommit.share;

import coffeemachine.thirdparties.DrinkMaker;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dontcommit.DrinkDispenser;
import dontcommit.Order;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Stepdefs {

    private final Context context;

    public Stepdefs(Context context) {
        this.context = context;
    }

    @When("^a (.+) is ordered$")
    public void drink_ordered(String drinkType) throws Throwable {
        Order order = new Order(Order.DrinkType.from(drinkType), 0);
        context.getDispenser().takeOrder(order);
    }


}
