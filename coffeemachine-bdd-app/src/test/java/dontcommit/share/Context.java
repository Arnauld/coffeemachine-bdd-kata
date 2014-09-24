package dontcommit.share;

import coffeemachine.thirdparties.DrinkMaker;
import dontcommit.DrinkDispenser;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Context {

    private DrinkMaker maker;
    private DrinkDispenser dispenser;

    public Context() {
    }

    public void setMaker(DrinkMaker maker) {
        this.maker = maker;
    }

    public DrinkMaker getMaker() {
        if (maker == null)
            maker = new DrinkMaker();
        return maker;
    }

    public DrinkDispenser getDispenser() {
        if (dispenser == null) {
            dispenser = new DrinkDispenser(getMaker());
        }
        return dispenser;
    }
}
