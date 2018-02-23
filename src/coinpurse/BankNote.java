package coinpurse;

/**
 * BankNote has a different serial number.
 * BankNote represents coinage (money) with a fixed value and currency.
 *
 * @author Raksani Khunamas.
 */
public class BankNote extends Money {
    /**
     * serialnumber of banknote.
     */
    private long serialNumber;

    /**
     * Constructor for a BankNote with a value and currency.
     *
     * @param value    is the value of money.
     * @param currency is the currency of each value.
     */
    public BankNote(double value, String currency, long serialNumber) {
        super(value, currency);
        this.serialNumber = serialNumber++;
    }

    /**
     * @return the serial number (long).
     */
    public long getSerial() {
        return serialNumber;
    }

    /**
     * @return "xxx-Currency note [serialnum]"
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getValue() + "-" + this.getCurrency() + " note [" + this.getSerial() + "]";
    }

//    public static void setNextSerialNumber(long nextSerialNumber) {
//        BankNote.nextSerialNumber = nextSerialNumber;
//    }
}