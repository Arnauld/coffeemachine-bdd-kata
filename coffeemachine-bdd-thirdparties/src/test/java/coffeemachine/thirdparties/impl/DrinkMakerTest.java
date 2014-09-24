package coffeemachine.thirdparties.impl;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkMakerTest {

    @BeforeClass
    public static void processing() {
        Processing.none();
    }

    @Test
    public void valid_command_should_be_appended_simple_case() {
        DrinkMaker drinkMaker = new DrinkMaker();
        drinkMaker.prepareDrink("Ch:1:0");
        assertThat(drinkMaker.transactionLog()).containsExactly("Coffee;extra hot;1;stick");
    }

}
