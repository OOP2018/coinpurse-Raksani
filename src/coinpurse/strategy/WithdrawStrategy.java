package coinpurse.strategy;
import coinpurse.Valuable;
import java.util.List;

/**
 * javadoc in paper.
 */

public interface WithdrawStrategy {
    public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables);
}
