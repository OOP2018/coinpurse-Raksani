package coinpurse;

public class MoneyFactoryDemo {
    /**
     * @author Raksani Khunamas.
     * This class is for indicating output of createMoney and setFactory.
     * By using .toString() print out.
     */
    public static void main(String[] args) {
        /**
         * set to Thai factory and print. ex. "100.0-Baht note [1000000]".
         */
        MoneyFactory.setFactory(new ThaiMoneyFactory());
        MoneyFactory thaiFactory = MoneyFactory.getInstance();
        Valuable thaiM = thaiFactory.createMoney(0.50);
        System.out.println(thaiM.toString());
        Valuable thaiM2 = thaiFactory.createMoney("100.0");
        System.out.println(thaiM2.toString());
        Valuable thaiM3 = thaiFactory.createMoney("500.0");
        System.out.println(thaiM3.toString());

        /**
         * set to Thai factory and print. ex. "5.0-Ringgit note [1000000]".
         */
        MoneyFactory.setFactory(new MalayMoneyFactory());
        MoneyFactory malayFactory = MoneyFactory.getInstance();
        Valuable malayM = malayFactory.createMoney(0.10);
        System.out.println(malayM.toString());
        Valuable malayM2 = malayFactory.createMoney("1.0");
        System.out.println(malayM2.toString());
        Valuable malayM3 = malayFactory.createMoney("5.0");
        System.out.println(malayM3.toString());

    }
}
