package coinpurse;

public abstract class MoneyFactory {
    /**
     * @author Raksani Khunamas
     * this the main class of ThaiFactory and MalayFactory.
     */
    private static MoneyFactory ourInstance = null;

    public static MoneyFactory getInstance() {
        return ourInstance;
    }

    /**
     * @param value that user entered.
     * @return Valuable of Coin() or Banknote() types.
     */
    public abstract Valuable createMoney(double value);

    public Valuable createMoney(String value) {
        try {
            return createMoney(Double.parseDouble(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The value is not a number.");
        }
    }

    /**
     * set f as the factory in each currency.
     */
    public static void setFactory(MoneyFactory f) {
        ourInstance = f;
    }

    protected MoneyFactory() {

    }
}
