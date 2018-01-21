package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtill {

	public static List<Coin> coins = new ArrayList<Coin>();
	public static void printCoins(List<Coin> coin){
		for(Coin coins : coin){
			System.out.printf("\t %s \n",coins.toString());
		}
		
	}
	public static void sortCoins() {
		coins.add(new Coin(0.25, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(0.50, "Won"));
		coins.add(new Coin(5.0, "Baht"));
		coins.add(new Coin(10.0, "Won"));
		
		printCoins(coins); // TODO write a method to print the coins
		// This static method sorts any list of Comparable objects
		java.util.Collections.sort(coins);
		System.out.println("Sort");
		printCoins(coins); // the coins should be sorted by value now
	}
	public static void main( String[] args ) {
		
		sortCoins();
	}
}
