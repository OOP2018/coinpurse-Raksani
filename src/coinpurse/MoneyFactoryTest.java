package coinpurse;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test the MoneyFactory using JUnit.
 * This is a JUnit 4 test suite.
 *
 * @author Raksani Khunamas.
 */

public class MoneyFactoryTest {

    @Test
    public void testSingleton() {
        MoneyFactory f1 = MoneyFactory.getInstance();
        MoneyFactory f2 = MoneyFactory.getInstance();
        assert (f1 == f2);

    }

    @Test
    public void testThaiMoney() {
        MoneyFactory a = new ThaiMoneyFactory();
        //By double
        //test coin
        assertEquals(0.25, a.createMoney(0.25).getValue());
        assertEquals(0.5, a.createMoney(0.5).getValue());
        assertEquals(1.0, a.createMoney(1.0).getValue());
        assertEquals(2.0, a.createMoney(2.0).getValue());
        assertEquals(5.0, a.createMoney(5.0).getValue());
        assertEquals(10.0, a.createMoney(10.0).getValue());
        //test banknote
        assertEquals(20.0, a.createMoney(20).getValue());
        assertEquals(50.0, a.createMoney(50).getValue());
        assertEquals(100.0, a.createMoney(100).getValue());
        assertEquals(500.0, a.createMoney(500).getValue());
        assertEquals(1000.0, a.createMoney(1000).getValue());
        //test currency
        assertEquals("Baht", a.createMoney(50).getCurrency());
        assertEquals("Baht", a.createMoney(10).getCurrency());


        //By String
        //test coin
        assertEquals(0.25, a.createMoney("0.25").getValue());
        assertEquals(0.5, a.createMoney("0.5").getValue());
        assertEquals(1.0, a.createMoney("1.0").getValue());
        assertEquals(2.0, a.createMoney("2.0").getValue());
        assertEquals(5.0, a.createMoney("5.0").getValue());
        assertEquals(10.0, a.createMoney("10.0").getValue());
        //test banknote
        assertEquals(20.0, a.createMoney("20.0").getValue());
        assertEquals(50.0, a.createMoney("50.0").getValue());
        assertEquals(100.0, a.createMoney("100.0").getValue());
        assertEquals(500.0, a.createMoney("500.0").getValue());
        assertEquals(1000.0, a.createMoney("1000.0").getValue());
    }

    @Test
    public void testMalayMoney() {
        MoneyFactory a = new MalayMoneyFactory();
        //test coin
        assertEquals(0.05, a.createMoney(0.05).getValue());
        assertEquals(0.10, a.createMoney(0.10).getValue());
        assertEquals(0.20, a.createMoney(0.20).getValue());
        assertEquals(0.50, a.createMoney(0.50).getValue());
        //test banknote
        assertEquals(1.0, a.createMoney(1.0).getValue());
        assertEquals(2.0, a.createMoney(2.0).getValue());
        assertEquals(5.0, a.createMoney(5.0).getValue());
        assertEquals(10.0, a.createMoney(10.0).getValue());
        assertEquals(20.0, a.createMoney(20.0).getValue());
        assertEquals(50.0, a.createMoney(50.0).getValue());
        assertEquals(100.0, a.createMoney(100.0).getValue());
        //test currency
        assertEquals("Sen", a.createMoney(0.50).getCurrency());
        assertEquals("Ringgit", a.createMoney(50).getCurrency());

        //By String
        //test coin
        assertEquals(0.05, a.createMoney("0.05").getValue());
        assertEquals(0.10, a.createMoney("0.10").getValue());
        assertEquals(0.20, a.createMoney("0.20").getValue());
        assertEquals(0.50, a.createMoney("0.50").getValue());
        //test banknote
        assertEquals(1.0, a.createMoney("1.0").getValue());
        assertEquals(2.0, a.createMoney("2.0").getValue());
        assertEquals(5.0, a.createMoney("5.0").getValue());
        assertEquals(10.0, a.createMoney("10.0").getValue());
        assertEquals(20.0, a.createMoney("20.0").getValue());
        assertEquals(50.0, a.createMoney("50.0").getValue());
        assertEquals(100.0, a.createMoney("100.0").getValue());

    }

    @Test
    public void testSetFactory() {

        MoneyFactory.setFactory(new MalayMoneyFactory());
        MoneyFactory mFactory = MoneyFactory.getInstance();
        MoneyFactory.setFactory(new ThaiMoneyFactory());
        MoneyFactory tFactory = MoneyFactory.getInstance();
        assertFalse(mFactory == tFactory);


    }
}
