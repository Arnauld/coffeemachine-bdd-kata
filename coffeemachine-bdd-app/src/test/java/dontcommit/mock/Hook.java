package dontcommit.mock;

import coffeemachine.thirdparties.DrinkMaker;
import cucumber.api.java.Before;
import dontcommit.share.Context;
import org.mockito.Mockito;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Hook {

    private final Context context;

    public Hook(Context context) {
        this.context = context;
    }

    @Before
    public void setUp() {
        DrinkMaker drinkMaker = Mockito.mock(DrinkMaker.class);
        context.setMaker(drinkMaker);
    }
}
