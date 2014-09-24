package coffeemachine.thirdparties.impl;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Processing {

    private static boolean process = true;

    public static void process(String s, int durationInMillis) {
        if(!process)
            return;
        try {
            Thread.sleep(durationInMillis);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    static void none() {
        process = false;
    }
}
