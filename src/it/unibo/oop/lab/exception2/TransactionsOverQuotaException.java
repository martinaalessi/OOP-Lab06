/**
 * 
 */
package it.unibo.oop.lab.exception2;

/**
 * @author marti
 *
 */
public class TransactionsOverQuotaException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -5186015990336694793L;
    private int totalTransactionCount;
    private final int maximumAllowedATMTransactions;
    
    public TransactionsOverQuotaException(int totalTransactionCount, int maximumAllowedATMTransactions) {
        super();
        this.totalTransactionCount = totalTransactionCount;
        this.maximumAllowedATMTransactions = maximumAllowedATMTransactions;
    }

    @Override
    public String toString() {
        return "TransactionsOverQuotaException [totalTransactionCount=" + totalTransactionCount
                + ", maximumAllowedATMTransactions=" + maximumAllowedATMTransactions + "]";
    }
    
    public String getMessage() {
        return toString();
    }
}
