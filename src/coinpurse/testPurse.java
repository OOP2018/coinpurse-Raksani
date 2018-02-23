package coinpurse;

/**
 * test the purse by me
 * @author Raksani Khunamas.
 */
public class testPurse {
    public static void main(String[] args) {
        Purse purse = new Purse(3);
        System.out.println(purse.getBalance());
        purse.insert(new BankNote(100,"Baht",1000000));
        purse.insert(new BankNote(50,"Baht",1000000));
        purse.insert(new Coin(0.25,"Baht"));
        purse.insert(new Coin(2,"Baht"));
        System.out.println(purse.getBalance());
        purse.withdraw(100.25);
        System.out.println(purse.toString());
    }
}
