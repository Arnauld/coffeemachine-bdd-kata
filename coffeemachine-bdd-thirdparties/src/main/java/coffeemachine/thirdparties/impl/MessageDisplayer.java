package coffeemachine.thirdparties.impl;

import coffeemachine.thirdparties.IMessageDisplayer;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class MessageDisplayer implements IMessageDisplayer {

    @Override
    public void display(String message) {
        Out.infoLn("Sending the message: %1$s", message);
        Processing.process("Displaying message", 1000);
        Out.infoLn("Message sent: %1$s", message);
    }
}
