package coffeemachine.thirdparties;

import java.util.List;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public interface IDrinkMaker {
    void executeCommand(String command);

    List<String> transactionLog();
}
