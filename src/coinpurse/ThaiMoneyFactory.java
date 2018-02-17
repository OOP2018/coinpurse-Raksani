package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {
    private final String thaiCurrency = "Baht";

    public ThaiMoneyFactory () {
        BankNote.setNextSerialNumber(1000000);
    }
    /**
     *
     * @param value
     * @return
     */
    @Override
    public Valuable createMoney(double value) {
        if(value == 0.25 || value == 0.50 || value == 1 || value ==2 || value ==5 || value == 10 ) return new Coin(value,thaiCurrency);
        else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) return new BankNote(value,thaiCurrency);
        else throw new IllegalArgumentException("It's not Thai currency");

    }
}
