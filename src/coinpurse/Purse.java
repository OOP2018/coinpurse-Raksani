package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

/**
 * A Valuable purse contains money. You can insert valuables, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Raksani Khunamas.
 */
public class Purse {
    private Comparator<Valuable> comp = new ValueComparator();
	/** Collection of objects in the purse. */
    private List<Valuable> money; // list of Valuable
	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of valuables you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>(); // array of Valuable
	}

	/**
	 * Count and return the number of valuables in the purse. This is the number of
	 * valuables, not their value.
	 * 
	 * @return the number of valuables in the purse.
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0.0;
		for (Valuable val : money) {
			balance += val.getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the valuable purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (money.size() >= capacity) {
			return true;
		}
		return false;
	}

	/**
	 * Insert a valuable into the purse. The valuable is only inserted if the purse has
	 * space for it and the valuable has positive value. No worthless valuables!
	 * 
	 * @param val
	 *            is a Valuable object to insert into purse
	 * @return true if valuable inserted, false if can't insert
	 */
	public boolean insert(Valuable val) {
		// if the purse is already full then can't insert anything.
		if (isFull()) {
			//System.out.println("the purse is full.");
			return false;
		} else {
			if (val.getValue() > 0) {
				money.add(val);
				return true;
			}
			return false;
		}
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuables
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {
		List<Valuable> withDraw = new ArrayList<Valuable>();	
		if (amount.getValue() < 0 || this.getBalance() < amount.getValue()) {
			return null;
		}
	    money.sort(comp);

		double amountNeededToWithdraw = amount.getValue();

		for (int i = money.size() - 1; i >= 0; i--) {

			if (amountNeededToWithdraw >= 0 && amount.getCurrency() == money.get(i).getCurrency()) {
				if ((amountNeededToWithdraw - money.get(i).getValue()) >= 0) {
					amountNeededToWithdraw -= money.get(i).getValue();
					withDraw.add(money.get(i));
					money.remove(i);
				}
			}
		}

		if (amountNeededToWithdraw > 0) {
			money.addAll(withDraw);
			return null;
		}
		return withDraw.toArray(new Valuable[withDraw.size()]);
	}

	public Valuable[] withdraw(double amount) {
		return withdraw(new Money(amount,"Baht"));
	}
	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	@Override
	public String toString() {
		//sort the money
		//java.util.Collections.sort(money);
		return String.format("In your purse has %d valuable with value %.2f ", count(), getBalance());
	}

}
