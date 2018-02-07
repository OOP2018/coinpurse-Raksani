package coinpurse;

/*
 * BankNote has a different serial number.
 * BankNote represents coinage (money) with a fixed value and currency.
 * @author Raksani Khunamas.
 */
public class BankNote implements Valuable {
	/*
	 * nextSerialNumber contains the next serial number.
	 */
	private static long nextSerialNumber = 1000000;
	/*
	 * value of banknote.
	 */
	private double value;
	/*
	 * currency of banknote.
	 */
	private String currency;
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
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	}

	/*
	 * @return the value of this BankNote.
	 * 
	 * @see coinpurse.Valuable#getValue()
	 */
	public double getValue() {
		return value;
	}

	/*
	 * @see coinpurse.Valuable#getCurrency()
	 * 
	 * @return the currency of banknote.
	 */
	public String getCurrency() {
		return currency;
	}

	/*
	 * @return the serial number (long).
	 */
	public long getSerial() {
		return serialNumber;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * @return true if obj is a BankNote and has the same currency and value.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (this == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		BankNote other = (BankNote) obj;
		return (this.currency.equals(other.currency)) && (this.value == other.value);
	}

	/*
	 * @see java.lang.Object#toString()
	 * 
	 * @return "xxx-Currency note [serialnum]"
	 */
	@Override
	public String toString() {
		return value + "-" + currency + " note [" + serialNumber + "]";
	}
}
