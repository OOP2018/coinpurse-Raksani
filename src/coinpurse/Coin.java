package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Raksani Khunamas.
 */
public class Coin extends Money {
	

	public Coin(double value, String currency) {
		super(value, currency);
	}

	@Override
	public String toString() {
		return this.getValue() + "-" + this.getCurrency();
	}
}
