package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
    /**
     * @author Raksani Khunamas.
     * this class is for creating Malaysia money
     */

    //set "Sen" as Malay banknote currency.
    private final String malayCurrencyCoin = "Sen";
    //set "Ringgit" as Malay banknote currency.
    private final String malayCurrencyNote = "Ringgit";
    //set Malay banknote's serial number.
    private long malayNextSerialNumber = 1000000;

    public MalayMoneyFactory() {

    }

    /**
     * @param value of money that user entered in double type.
     * @return Valuable in Coin() or Banknote() type in Thai currency or warning in case of it doesn't match with Malay coins or banknotes.
     */

    @Override
    public Valuable createMoney(double value) {
        if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) return new Coin(value, malayCurrencyCoin);
        else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100)
            return new BankNote(value, malayCurrencyNote, malayNextSerialNumber++);
        else throw new IllegalArgumentException("It's not Malay currency");

    }
}
