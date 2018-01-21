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
		if (value >= 0) {
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
		if (this == null) {
			return false;
		}
		Coin other = (Coin) obj;
		return (this.currency.equals(other.currency)) && (this.value == other.value);
	}

	public int compareTo(Coin coin) {
		if (coin.value == value) {
			return 0;
		}
		if (coin.value > value) {
			return -1;
		}
		return 1;
	}
	
	public String toString(){
		return value+"-"+currency;
	}
}
