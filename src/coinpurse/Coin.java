package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Raksani Khunamas.
 */
public class Coin implements Comparable<Coin> {
	private double value;
	private String currency;

	public Coin(double value, String currency) {
		if (value > 0) {
			this.value = value;
		}
		this.currency = currency;
	}

	public double getValue() {
		return value;
	}

	public String getCurrency() {
		return currency;
	}

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
		Coin other = (Coin) obj;
		return (this.currency.equals(other.currency)) && (this.value == other.value);
	}

	@Override
	public int compareTo(Coin coin) {
		if (coin.getValue() == this.getValue()) {
			return 0;
		}
		if (coin.getValue() > this.getValue()) {
			return -1;
		}
		return 1;
	}

	@Override
	public String toString() {
		return value + "-" + currency;
	}
}
