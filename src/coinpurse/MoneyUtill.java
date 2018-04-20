package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtill {

	/**
	 * Return the larger argument, based on sort order, using
	 * the objects' own compareTo method for comparing.
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E ... args) {
		E largest = args[0];
		for(E e : args) largest = (e.compareTo(largest) > 0) ? e : largest;
		return largest;
		//don't use Arrays.sort -- its inefficient for this task
	}

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
	public static void sortMoney(List<? extends Valuable> valuables ) {
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
	public static <E extends Valuable> List<E> filterByCurrency(List<E> valuables, String currency) {
		List<E> filteredByCurrencyCoins = new ArrayList<E>();
		for (E valuable : valuables) {
			if (valuable.getCurrency().equals(currency)) {
				filteredByCurrencyCoins.add(valuable);
			}
		}
		return filteredByCurrencyCoins;
	}

	public static void main(String[] args) {
		valuables.add(new BankNote(20,"Bath",1000000));
		valuables.add(new BankNote(100,"Bath",1000000));
		valuables.add(new BankNote(40,"Bath",1000000));
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
		sortMoney(valuables);
		System.out.println("After Sort");
		printCoins(valuables); // the valuables should be sorted by value now.
		filterByCurrency(valuables, "Baht");
		printCoins(valuables); // the valuables should be filtered by currency.
	}
}
