package coinpurse;

import java.util.Comparator;

/**
 * ValueComparator is sorting items in the purse.
 * @author Raksani Khunamas.
 */
public class ValueComparator implements Comparator<Valuable> {
	/**
	 * Compare two objects that implement Valuable. First compare them by
	 * currency, so that "Baht" < "Dollar". If both objects have the same
	 * currency, order them by value.
	 * 
	 * @param a
	 *            is the Valuable that the Comparator will compare with b.
	 * @param a
	 *            is the Valuable that the Comparator will compare with a.
	 * @return  1 in case of a > b 
	 * 			0 in case of a = b 
	 * 		   -1 in case of a < b
	 */
	public int compare(Valuable a, Valuable b) {
		if(a.getCurrency().equals(b.getCurrency())){
			if(a.getValue()>b.getValue()) return 1;
			else if(a.getValue()==b.getValue()) return 0;
			else return -1;
		}
		else{
			return a.getCurrency().compareTo(b.getCurrency());
		}
	}
}
