/**
 * 
 */
package it.unibo.oop.lab.exception2;

/**
 * @author marti
 *
 */
public class NotEnoughFoundsException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -1159808475879283028L;
    private double balance;
    private double amount;
    
    public NotEnoughFoundsException(double balance, double amount) {
        super();
        this.balance = balance;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "NotEnoughFoundsException [balance=" + balance + ", amount=" + amount + "]";
    }
    
    public String getMessage() {
        return toString();
    }
}
