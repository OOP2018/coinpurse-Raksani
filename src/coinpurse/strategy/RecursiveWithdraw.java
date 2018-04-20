package coinpurse.strategy;

import coinpurse.Valuable;

import java.util.ArrayList;
import java.util.List;

public class RecursiveWithdraw implements WithdrawStrategy {
    private List<Valuable> list = new ArrayList<>();

    @Override
    public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables) {
        if (helpRecursion(0, valuables, amount.getValue(),amount)) return list;
        return new ArrayList<>();
    }

    public boolean helpRecursion(int start, List<Valuable> valuables, double target,Valuable amount) {
        if (start >= valuables.size()) return target == 0;
        if (helpRecursion(start + 1, valuables, target - valuables.get(start).getValue(),amount)) {
            list.add(valuables.get(start));
            valuables.remove(start);
            return true;
        }
        return helpRecursion(start + 1, valuables, target,amount);
    }
}
