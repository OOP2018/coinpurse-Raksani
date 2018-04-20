package coinpurse.strategy;

import coinpurse.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * 6 tests methods
 * test withdraw everything (/)
 * test withdraw everything without one item.
 * test withdraw more than total value(must be fail)
 * test withdraw more than 1 solutions. #testimpossible (/)
 */
public class WithdrawTest {
    private WithdrawStrategy strategy;
    private WithdrawStrategy strategy1;
    /**
     * tolerance for comparing two double values
     */
    private static final double TOL = 1.0E-6;
    private static final String CURRENCY = "Baht";
    private static final String CURRENCY2 = "Ringgit";
    private static final long serialnumber = 1000000;

    /**
     * Make a coin with the default currency. To save typing "new Coin(...)"
     */
    private Coin makeCoin(double value) {
        return new Coin(value, CURRENCY);
    }

    private BankNote makeBanknote(double value) {
        return new BankNote(value, CURRENCY, serialnumber);
    }

    /**
     * Code to run before each test. Setup the "test fixture".
     */
    @Before
    public void setUp() {
        strategy = new GreedyWithdraw();
    }

    /**
     * Add one coin and remove it.
     */
    @Test(timeout = 1000)
    public void testEasyWithdraw() {
        strategy = new GreedyWithdraw();
        List<Valuable> wallet = new ArrayList<>();
        //Purse purse = new Purse(10);
        double[] values = {1, 20, 0.5, 10}; // values of valuables we will insert

        for (double value : values) {
            Money coin = makeCoin(value);
            //Money banknote = makeBanknote(value);
            assertTrue(wallet.add(coin));
            assertEquals(value, getBalance(wallet), TOL);
            List<Valuable> result = strategy.withdraw(makeCoin(value), wallet);
            assertTrue(result != null);
            assertEquals(1, result.size());
            assertEquals(0, getBalance(wallet), TOL);
        }
    }


    /**
     * Add 4 valuables and then withdraw in pairs, but not in same order.
     */
    @Test(timeout = 1000)
    public void testMultiWithdraw() {
        Purse purse = new Purse(10);
        Money[] coins = {makeCoin(5.0), makeCoin(10.0), makeCoin(1.0), makeCoin(5.0)};
        // insert them all
        for (Money coin : coins) assertTrue(purse.insert(coin));

        double amount1 = coins[1].getValue() + coins[3].getValue();
        double amount2 = coins[0].getValue() + coins[2].getValue();
        assertEquals(amount1 + amount2, purse.getBalance(), TOL);

        Valuable[] wd1 = purse.withdraw(amount1);
        //assertEquals(amount1, sum(wd1), TOL);

        assertEquals(amount2, purse.getBalance(), TOL);
        Valuable[] wd2 = purse.withdraw(amount2);

        // should be empty now
        assertEquals(0, purse.getBalance(), TOL);
    }


    /**
     * Withdraw full amount in purse, using varying numbers of objects.
     */
    @Test(timeout = 1000)
    public void testWithdrawEverything() {
        //create new purse
        //Purse purse = new Purse(10);
        strategy = new GreedyWithdraw();
        List<Valuable> wallet = new ArrayList<>();
        // Coins we want to insert and then withdraw.
        // Use values such that greedy will succeed, but not monotonic
        List<Coin> coins = Arrays.asList(
                makeCoin(1.0), makeCoin(0.5), makeCoin(10.0), makeCoin(0.25), makeCoin(5.0)
        );
        // num = number of valuables to insert and then withdraw
        for (int num = 1; num <= coins.size(); num++) {
            double amount = 0.0;
            List<Coin> subList = coins.subList(0, num);
            for (Money c : subList) {
                wallet.add(c);
                amount += c.getValue();
            }
            // balance should be exactly what we just inserted
            assertEquals(amount, getBalance(wallet), TOL);
            // can we withdraw it all?
            List<Valuable> result = strategy.withdraw(makeCoin(amount), wallet);
            String errmsg = String.format("couldn't withdraw %.2f but purse has %s",
                    amount, Arrays.toString(subList.toArray()));
            assertNotNull(errmsg, result);
            // is the amount correct?
            assertEquals("Withdraw wrong amount", amount, sum(result), TOL);
            // should not be anything left in the purse
            assertEquals(0.0, getBalance(wallet), TOL);
        }

        strategy = new GreedyWithdraw();
        List<Valuable> wallet1 = new ArrayList<>();
        //Banknotes we want to insert and then withdraw.
        List<BankNote> bankNotes = Arrays.asList(makeBanknote(20), makeBanknote(50), makeBanknote(100));
        for (int num1 = 1; num1 <= bankNotes.size(); num1++) {
            double amount1 = 0.0;
            List<BankNote> subList1 = bankNotes.subList(0, num1);
            for (Money c1 : subList1) {
                wallet1.add(c1);
                amount1 += c1.getValue();
            }
            // balance should be exactly what we just inserted
            assertEquals(amount1, getBalance(wallet1), TOL);

            List<Valuable> result1 = strategy.withdraw(makeBanknote(amount1), wallet1);
            String errmsg1 = String.format("couldn't withdraw %.2f but purse has %s",
                    amount1, Arrays.toString(subList1.toArray()));
            assertNotNull(errmsg1, result1);
            assertEquals("Withdraw wrong amount", amount1, sum(result1), TOL);
            assertEquals(0.0, getBalance(wallet1), TOL);

        }

    }


    @Test
    public void testMoreThanOneSolutionWithdraw() {
        //Purse purse = new Purse(10);
        strategy = new GreedyWithdraw();
        List<Valuable> wallet = new ArrayList<>();
        //withdraw when purse is empty. then it must be null.
        assertNull(strategy.withdraw(makeCoin(1), wallet));
        //insert coin 20.0
        wallet.add(makeCoin(20));
        //cannot withdraw 1.0/19.0/21.0 because it has only 1 coin (20.0)
        assertNull(strategy.withdraw(makeCoin(1), wallet));
        assertNull(strategy.withdraw(makeCoin(19), wallet));
        assertNull(strategy.withdraw(makeCoin(21), wallet));
        wallet.add(makeCoin(20)); // now it has 20 + 20
        //cannot withdraw because it has only 2 coins which has each value 20.0
        assertNull(strategy.withdraw(makeCoin(30), wallet));
    }

    @Test
    public void testWithdrawExceptOne() {
        List<Valuable> wallet = new ArrayList<>();
        double[] values = {1, 20, 0.5, 10};
        for (double value : values) {
            Valuable coin = makeCoin(value);
            assertTrue(wallet.add(coin));
        }
        strategy.withdraw(makeCoin(1), wallet);
        assertEquals(1, wallet.size());
        assertEquals(makeCoin(1), wallet);
    }

    /**
     * Sum the value of some valuables.
     *
     * @param wd1 array of valuables
     * @return sum of values of the valuables
     */
    private double sum(List<Valuable> wd1) {
        if (wd1 == null) return 0.0;
        double sum = 0;
        for (Valuable v : wd1) if (v != null) sum += v.getValue();
        return sum;
    }

    /**
     * Get the total value of all items in the purse.
     *
     * @return the total value of items in the purse.
     */
    public double getBalance(List<Valuable> money) {
        double balance = 0.0;
        for (Valuable val : money) {
            balance += val.getValue();
        }
        return balance;
    }


}
