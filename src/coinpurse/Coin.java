package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Raksani Khunamas.
 */
public class Coin extends Money {


	/**
	 *
	 * @param value of entered money.
	 * @param currency entered money.
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	@Override
	public String toString() {
		return this.getValue() + "-" + this.getCurrency();
	}
}
