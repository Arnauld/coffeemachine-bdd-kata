package coffeemachine.thirdparties.impl;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Out {

    static void infoLn(String fmt, Object... args) {
        System.out.println(String.format(fmt, args));
    }

    static void newLn() {
        System.out.println();
    }

    static void info(String fmt, Object... args) {
        System.out.print(String.format(fmt, args));
    }
}
