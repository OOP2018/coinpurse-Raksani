package coinpurse.strategy;

import coinpurse.Purse;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GreedyWithdraw implements WithdrawStrategy{
    /**
     * Withdraw the requested amount of money. Return an array of Valuables
     * withdrawn from purse, or return null if cannot withdraw the amount
     * requested.
     *
     * @param amount
     *            is the amount to withdraw
     * @return list of Valuable objects for money withdrawn, or null if cannot
     *         withdraw requested amount.
     */
    private Purse purse;
    private Comparator<Valuable> comp = new ValueComparator();

    @Override
    public List<Valuable> withdraw(Valuable amount,List<Valuable> valuables) {
        List<Valuable> withDraw = new ArrayList<Valuable>();
        if (amount.getValue() < 0 ) {
            return null;
        }
        valuables.sort(comp);

        double amountNeededToWithdraw = amount.getValue();

        for (int i = valuables.size() - 1; i >= 0; i--) {

            if (amountNeededToWithdraw >= 0 && amount.getCurrency() == valuables.get(i).getCurrency()) {
                if ((amountNeededToWithdraw - valuables.get(i).getValue()) >= 0) {
                    amountNeededToWithdraw -= valuables.get(i).getValue();
                    withDraw.add(valuables.get(i));
                    valuables.remove(i);
                }
            }
        }

        if (amountNeededToWithdraw > 0) {
            valuables.addAll(withDraw);
            return null;
        }
        return withDraw;
    }


}
