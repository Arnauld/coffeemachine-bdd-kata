package coffeemachine.thirdparties;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class CashMachineTest {

    public static final Offset<Double> EPS = offset(0.001);

    @Test
    public void usecase () {
        CashMachine cashMachine = new CashMachine();
        cashMachine.insertMoney(2);


        assertThat(cashMachine.getMissingMoney(0.60)).isEqualTo(0);
        assertThat(cashMachine.getMissingMoney(2.60)).isEqualTo(0.60, EPS);
    }
}
