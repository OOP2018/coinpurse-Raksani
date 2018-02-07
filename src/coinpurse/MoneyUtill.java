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
	 * To print the whole list of valuables.
	 * @param valuables is the list of the coin related with Coin class.
	 */
	public static List<Valuable> valuables = new ArrayList<Valuable>();

	public static void printCoins(List<Valuable> valuables) {
		for (Valuable valuable : valuables) {
			System.out.printf("\t %s \n", valuable.toString());
		}

	}

	/*
	 * To sort the valuables. Order by min to max value.
	 * 
	 * @param valuables is the list of the coin related with Coin class.
	 */
	public static void sortCoins() {
		ValueComparator comp = new ValueComparator();
		// This static method sorts any list of Comparable objects
		java.util.Collections.sort(valuables,comp);
	}

	/**
	 * Filter the coin by use their currency.
	 * 
	 * @param valuables
	 *            is the list of the coin related with Coin class.
	 * @param currency
	 *            is the currency of each value, can be various.
	 * @return the list after sort and filter by currency.
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> valuables, String currency) {
		List<Valuable> filteredByCurrencyCoins = new ArrayList<Valuable>();
		for (Valuable valuable : valuables) {
			if (valuable.getCurrency().equals(currency)) {
				filteredByCurrencyCoins.add(valuable);
			}
		}
		return filteredByCurrencyCoins;
	}

	public static void main(String[] args) {
		valuables.add(new BankNote(20,"Bath"));
		valuables.add(new BankNote(100,"Bath"));
		valuables.add(new BankNote(40,"Bath"));
		valuables.add(new Coin(0.25, "Baht"));
		valuables.add(new Coin(2.0, "Baht"));
		valuables.add(new Coin(1.0, "Baht"));
		valuables.add(new Coin(10.0, "Baht"));
		valuables.add(new Coin(0.50, "Won"));
		valuables.add(new Coin(5.0, "Baht"));
		valuables.add(new Coin(10.0, "Won"));
		//print the original coin's list.
		printCoins(valuables);
		//sort the valuables.
		sortCoins();
		System.out.println("After Sort");
		printCoins(valuables); // the valuables should be sorted by value now.
		filterByCurrency(valuables, "Baht");
		printCoins(valuables); // the valuables should be filtered by currency.
	}
}
