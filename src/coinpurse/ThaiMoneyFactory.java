package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {
    /**
     * @author Raksani Khunamas.
     * this class is for creating Thai money
     */

    //set "Baht" as Thai currency.
    private final String thaiCurrency = "Baht";
    //set Thai banknote's serial number.
    private long thaiNextSerialNumber = 2000000;

    public ThaiMoneyFactory() {

    }

    /**
     * @param value of money that user entered in double type.
     * @return Valuable in Coin() or Banknote() type in Thai currency or warning in case of it doesn't match with Thai coins or banknotes.
     */

    @Override
    public Valuable createMoney(double value) {
        if (value == 0.25 || value == 0.50 || value == 1 || value == 2 || value == 5 || value == 10)
            return new Coin(value, thaiCurrency);
        else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000)
            return new BankNote(value, thaiCurrency,thaiNextSerialNumber++);
        else throw new IllegalArgumentException("It's not Thai currency");

    }
}
