package coinpurse;

/*
 * BankNote has a different serial number.
 * BankNote represents coinage (money) with a fixed value and currency.
 * @author Raksani Khunamas.
 */
public class BankNote extends Money {
	/*
	 * nextSerialNumber contains the next serial number.
	 */
	private static long nextSerialNumber = 1000000;
	/*
	 * serialnumber of banknote.
	 */
	private long serialNumber = nextSerialNumber;

	/*
	 * Constructor for a BankNote with a value and currency.
	 *
	 * @param value is the value of money.
	 *
	 * @param currency is the currency of each value.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		this.serialNumber = nextSerialNumber++;
	}

	/*
	 * @return the serial number (long).
	 */
	public long getSerial() {
		return serialNumber;
	}

	/*
	 * @see java.lang.Object#toString()
	 *
	 * @return "xxx-Currency note [serialnum]"
	 */
	@Override
	public String toString() {
		return this.getValue() + "-" + this.getCurrency() + " note [" + serialNumber + "]";
	}

	public static void setNextSerialNumber(long nextSerialNumber) {
		BankNote.nextSerialNumber = nextSerialNumber;
	}
}