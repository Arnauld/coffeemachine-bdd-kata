package dontcommit;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Order {

    public Order(DrinkType drinkType, int nbSugar) {
        this.drinkType = drinkType;
        this.nbSugar = nbSugar;
    }

    public enum DrinkType {
        Coffee,
        Tea,;

        public static DrinkType from(String drinkType) {
            for (DrinkType type : values()) {
                if(type.name().equalsIgnoreCase(drinkType))
                    return type;
            }
            throw new IllegalArgumentException("Unrecognized type: '" + drinkType + "'");
        }
    }

    private final DrinkType drinkType;
    private final int nbSugar;
    private boolean extraHot;

    public String toCommand() {
        StringBuilder b = new StringBuilder();
        switch (drinkType) {
            case Coffee:
                b.append("C");
                break;

            case Tea:
                b.append("T");
                break;

            default:
                throw new IllegalArgumentException("Unsupported drink type '" + drinkType + "'");
        }

        if (extraHot) {
            b.append("h");
        }
        b.append(":");

        if (nbSugar > 0) {
            b.append(nbSugar).append(":0");
        } else {
            b.append(":");
        }

        return b.toString();
    }
}
