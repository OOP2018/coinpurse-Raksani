package coinpurse;

public abstract class MoneyFactory {
    /*
     *@author Raksani Khunamas
     */
    private static MoneyFactory ourInstance = null;

    public static MoneyFactory getInstance() {
        return ourInstance;
    }

    /**
     *
     * @param value
     * @return Valuable
     */
    public abstract Valuable createMoney(double value);

    public Valuable createMoney(String value){
        try{
            return createMoney(Double.parseDouble(value));
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("The value is not a number.");
        }
    }

    /**
     *
     * @param f
     */
    public static void setFactory(MoneyFactory f){
        ourInstance = f;
    }
    protected MoneyFactory() {

    }
}
