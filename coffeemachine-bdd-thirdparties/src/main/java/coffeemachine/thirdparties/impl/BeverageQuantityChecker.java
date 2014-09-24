package coffeemachine.thirdparties.impl;

import coffeemachine.thirdparties.IBeverageQuantityChecker;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class BeverageQuantityChecker implements IBeverageQuantityChecker {


    private Map<String, Quantity> stock;

    BeverageQuantityChecker() {
        Out.infoLn("Registering in the Object Naming service");
        Out.infoLn("Waiting for identifier ...");
    }

    private Map<String, Quantity> loadStock() {
        if(stock == null) {
            stock = Maps.newConcurrentMap();
            declare(stock, "Coffee", 10);
            declare(stock, "Chocolate", 10);
            declare(stock, "OrangeJuice", 10);
            declare(stock, "Tea", 10);
            declare(stock, "TomatoPotage", 10);
        }
        return stock;
    }

    private void declare(Map<String, Quantity> stock, String drink, int qty) {
        stock.put(drink, new Quantity(qty));
    }

    @Override
    public boolean isEmpty(String drink) {
        Out.infoLn("Checking remaining quantity of %1$s", drink);

        Quantity quantity = loadStock().get(drink);
        if (quantity == null)
            throw new IllegalArgumentException("ERR000156987a");

        if (quantity.isEmpty()) {
            Out.infoLn("Shortage of %1$s", drink);
            return true;
        }

        quantity.dec();
        return false;
    }

    private class Quantity {
        private int amount;

        public Quantity(int qty) {
            this.amount = qty;
        }

        public boolean isEmpty() {
            return amount == 0;
        }

        public void dec() {
            amount--;
        }
    }
}
