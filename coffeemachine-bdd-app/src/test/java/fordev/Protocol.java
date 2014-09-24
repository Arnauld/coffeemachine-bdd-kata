package fordev;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Protocol {
    public String toCommand(Order order) {
        if(order.getDrink().equalsIgnoreCase("Coffee"))
            return "C::";
        else
            return "T::";

    }
}
