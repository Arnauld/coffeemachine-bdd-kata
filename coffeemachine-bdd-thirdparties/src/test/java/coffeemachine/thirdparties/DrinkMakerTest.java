package coffeemachine.thirdparties;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkMakerTest {


    @Test
    public void valid_command_should_be_appended_simple_case() {
        DrinkMaker drinkMaker = new DrinkMaker() {
            @Override
            void waitALittle(int durationInMillis) {
            }
        };
        drinkMaker.prepareDrink("Ch:1:0");
        assertThat(drinkMaker.transactionLog()).containsExactly("Coffee;extra hot;1;stick");
    }

}
