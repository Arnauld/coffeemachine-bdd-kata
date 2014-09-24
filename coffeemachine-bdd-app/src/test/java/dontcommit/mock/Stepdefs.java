package dontcommit.mock;

import cucumber.api.java.en.Then;
import dontcommit.share.Context;

import static org.mockito.Mockito.verify;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Stepdefs {
    private final Context context;

    public Stepdefs(Context context) {
        this.context = context;
    }

    @Then("^a (Coffee|Tea) should be prepared$")
    public void should_be_prepared(String drinkType) throws Throwable {
        if(drinkType.equalsIgnoreCase("Coffee"))
            verify(context.getMaker()).executeCommand("C::");
        else if(drinkType.equalsIgnoreCase("Tea"))
            verify(context.getMaker()).executeCommand("T::");
        else
            throw new IllegalArgumentException("Unsupported drinktype '" + drinkType + "'");

    }
}
