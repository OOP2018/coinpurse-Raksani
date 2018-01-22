package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtill {

	/*
	 * For testing Coin class
	 * 
	 * @author Raksani Khunamas
	 * 
	 */
	/*
	 * To print the whole list of coins.
	 * @param coins is the list of the coin related with Coin class.
	 */
	public static List<Coin> coins = new ArrayList<Coin>();

	public static void printCoins(List<Coin> coin) {
		for (Coin coins : coin) {
			System.out.printf("\t %s \n", coins.toString());
		}

	}

	/*
	 * To sort the coins. Order by min to max value.
	 * 
	 * @param coins is the list of the coin related with Coin class.
	 */
	public static void sortCoins() {
		// This static method sorts any list of Comparable objects
		java.util.Collections.sort(coins);
	}

	/**
	 * Filter the coin by use their currency.
	 * 
	 * @param coins
	 *            is the list of the coin related with Coin class.
	 * @param currency
	 *            is the currency of each value, can be various.
	 * @return the list after sort and filter by currency.
	 */

	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> filteredByCurrencyCoins = new ArrayList<Coin>();
		for (Coin coin : coins) {
			if (coin.getCurrency().equals(currency)) {
				filteredByCurrencyCoins.add(coin);
			}
		}
		return filteredByCurrencyCoins;
	}

	public static void main(String[] args) {
		coins.add(new Coin(0.25, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(0.50, "Won"));
		coins.add(new Coin(5.0, "Baht"));
		coins.add(new Coin(10.0, "Won"));
		//print the original coin's list.
		printCoins(coins);
		sortCoins();
		System.out.println("After Sort");
		printCoins(coins); // the coins should be sorted by value now.
		filterByCurrency(coins, "Baht");
		printCoins(coins); // the coins should be filtered by currency.
	}
}
