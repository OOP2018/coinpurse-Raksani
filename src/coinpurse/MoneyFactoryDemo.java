package coinpurse;

public class MoneyFactoryDemo {
    private static void setFactory(String factoryClass){
        MoneyFactory factory = null;
        try{
            factory = (MoneyFactory) Class.forName(factoryClass).newInstance();
        } catch (IllegalArgumentException | InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            throw new IllegalArgumentException("Factory name is invalid");
        }
        MoneyFactory.setFactory(factory);
    }

    private static Money testCreateThaiCurrency(double value){
        if(value == 0.25 || value == 0.50 || value == 1 || value ==2 || value ==5 || value == 10 ) return new Coin(value,"Baht");
        else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) return new BankNote(value,"Baht");
        else throw new IllegalArgumentException("Something wrong with creating " + value + "Baht");
    }

    private static Money testCreateMalayCurrency(double value){
        if(value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) return new Coin(value, "Sen");
        else if (value == 1 || value ==2 || value ==5 || value == 10 || value == 20 || value == 50 || value == 100) return new BankNote(value,"Ringgit");
        else throw new IllegalArgumentException("Something wrong with creating " + value + "Ringgit");
    }

    private static void testCase(String testPrompt, Object expected, Object actual){
        System.out.println(testPrompt + "test");
        System.out.printf("Expected: %s, Actual: %s, Result: %s%n",expected,actual,expected.equals(actual));
    }

    private static void testThaiMoney(double[] amounts){
        //setFactory("coinpurse,ThaiMoneyFactory");
        MoneyFactory moneyFactory = MoneyFactory.getInstance();
        System.out.println("Test creating money.");
        for (double a : amounts ){
        }
    }

    public static void main(String[] args){
        double[] amounts = {1,2};
    }
}
