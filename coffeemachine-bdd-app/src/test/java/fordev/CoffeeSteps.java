package fordev;

import coffeemachine.thirdparties.impl.DrinkMaker;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class CoffeeSteps {

    private Orchestrator orchestrator;
    //
    private DrinkMaker drinkMaker;
    private ByteArrayOutputStream bout;

    @Before("@endToEnd")
    public void setUpEndToEnd() {
        orchestrator = new Orchestrator(new DrinkMaker());
        bout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bout));
    }

    @Before("@mock")
    public void setUp() {
        drinkMaker = Mockito.mock(DrinkMaker.class);
        orchestrator = new Orchestrator(drinkMaker);
    }

    @When("^I order a (.*)")
    public void i_order_a_Coffee(String drinkType) throws Throwable {
        Order order = new Order(drinkType);
        orchestrator.takeOrder(order);
    }


    @Then("^the command sent should be \"(.*?)\"$")
    public void the_command_sent_should_be(String expectedCommand) throws Throwable {
        if(drinkMaker != null) {
            Mockito.verify(drinkMaker).executeCommand(expectedCommand);
        }
        else {
            assertThat(bout.toString()).contains("Execution of command '" + expectedCommand + "'");
        }
    }

}
