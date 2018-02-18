package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
    private final String malayCurrencyCoin = "Sen";
    private final String malayCurrencyNote = "Ringgit";

    public MalayMoneyFactory () {
        BankNote.setNextSerialNumber(1000000);
    }
    /**
     *
     * @param value
     * @return caution in case of it doesn't match with Malaysia coins or banknotes.
     */
    @Override
    public Valuable createMoney(double value) {
        if(value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) return new Coin(value,malayCurrencyCoin);
        else if (value == 1 || value ==2 || value ==5 || value == 10 || value == 20 || value == 50 || value == 100) return new BankNote(value,malayCurrencyNote);
        else throw new IllegalArgumentException("It's not Malay currency");

    }
}
