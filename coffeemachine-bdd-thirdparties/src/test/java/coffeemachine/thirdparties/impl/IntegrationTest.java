package coffeemachine.thirdparties.impl;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
@RunWith(JUnitParamsRunner.class)
public class IntegrationTest {

    private DrinkMaker drinkMaker;

    @BeforeClass
    public static void processing() {
        Processing.none();
    }

    @Before
    public void setUp() {
        drinkMaker = new DrinkMaker();

    }

    @Test
    public void emailNotifier__drinkReport() {
        EmailNotifier emailNotifier = new EmailNotifier();
        emailNotifier.notifyDrinkReport("{ coffee: 4, tea: 10, total: 34.0€}");
    }

    @Test
    public void emailNotifier__missingDrink() {
        EmailNotifier emailNotifier = new EmailNotifier();
        emailNotifier.notifyMissingDrink("Coffee");
    }

    @Test
    @Parameters({
            "0.0",
            "0.1",
            "10.0"
    })
    public void cashMachine__missingMoney__no_money_inserted(double missingAndExpected) {
        CashMachine cashMachine = new CashMachine();
        assertThat(cashMachine.getMissingMoney(missingAndExpected)).isEqualTo(missingAndExpected);
    }

    @Test
    @Parameters({
            "1.00, 0.60",
            "0.10, 0.10",
            "0.60, 0.60",
    })
    public void cashMachine__missingMoney__too_much_money_inserted(double inserted, double price) {
        CashMachine cashMachine = new CashMachine();
        cashMachine.insertMoney(inserted);
        assertThat(cashMachine.getMissingMoney(price)).isEqualTo(0.0);
    }

    @Test
    @Parameters({
            "0.10, 0.60, 0.50"
    })
    public void cashMachine__missingMoney__not_enough_money_inserted(double inserted, double price, double expected) {
        CashMachine cashMachine = new CashMachine();
        cashMachine.insertMoney(inserted);
        assertThat(cashMachine.getMissingMoney(price)).isEqualTo(expected);
    }

    @Test
    @Parameters({
            "Coffee",
            "Chocolate",
            "OrangeJuice",
            "Tea",
            "TomatoPotage"
    })
    public void beverageQuantityChecker__10_quantity(String drink) {
        BeverageQuantityChecker beverageQuantityChecker = new BeverageQuantityChecker();
        for (int i = 0; i < 10; i++) {
            assertThat(beverageQuantityChecker.isEmpty(drink)).describedAs("Invocation #" + i).isFalse();
        }
        assertThat(beverageQuantityChecker.isEmpty(drink)).isTrue();
    }
}
