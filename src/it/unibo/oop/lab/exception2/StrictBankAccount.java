package it.unibo.oop.lab.exception2;

/**
 * Class modeling a BankAccount with strict policies: getting money is allowed
 * only with enough founds, and there are also a limited number of free ATM
 * transaction (this number is provided as a input in the constructor).
 * 
 */
public class StrictBankAccount implements BankAccount {

    private final int usrID;
    private double balance;
    private int totalTransactionCount;
    private final int maximumAllowedATMTransactions;
    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;

    /**
     * 
     * @param usrID
     *            user id
     * @param balance
     *            initial balance
     * @param maximumAllowedAtmTransactions
     *            max no of ATM transactions allowed
     */
    public StrictBankAccount(final int usrID, final double balance, final int maximumAllowedAtmTransactions) {
        this.usrID = usrID;
        this.balance = balance;
        this.maximumAllowedATMTransactions = maximumAllowedAtmTransactions;
    }

    /**
     * 
     * {@inheritDoc}
     * @throws WrongAccountHolderException 
     */
    public void deposit(final int usrID, final double amount) throws WrongAccountHolderException {
        if (checkUser(usrID)) {
            this.balance += amount;
            increaseTransactionsCount();
        }
    }

    /**
     * 
     * {@inheritDoc}
     * @throws WrongAccountHolderException 
     * @throws NotEnoughFoundsException 
     */
    public void withdraw(final int usrID, final double amount) throws WrongAccountHolderException, NotEnoughFoundsException {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
                this.balance -= amount;
                increaseTransactionsCount();
        } 
    }

    /**
     * 
     * {@inheritDoc}
     * @throws WrongAccountHolderException 
     * @throws TransactionsOverQuotaException 
     */
    public void depositFromATM(final int usrID, final double amount) throws WrongAccountHolderException, TransactionsOverQuotaException {
        if (totalTransactionCount < maximumAllowedATMTransactions) {
            this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
            increaseTransactionsCount();
        } else {
            throw new TransactionsOverQuotaException(totalTransactionCount, maximumAllowedATMTransactions);
        }
    }

    /**
     * 
     * {@inheritDoc}
     * @throws WrongAccountHolderException 
     * @throws NotEnoughFoundsException 
     * @throws TransactionsOverQuotaException 
     */
    public void withdrawFromATM(final int usrID, final double amount) throws WrongAccountHolderException, NotEnoughFoundsException, TransactionsOverQuotaException {
        if (totalTransactionCount < maximumAllowedATMTransactions) {
            this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
        } else {
            throw new TransactionsOverQuotaException(totalTransactionCount, maximumAllowedATMTransactions);
        }
    }

    /**
     * 
     * {@inheritDoc}
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getTransactionCount() {
        return totalTransactionCount;
    }

    /**
     * 
     * @param usrID
     *            id of the user related to these fees
     * @throws WrongAccountHolderException 
     * @throws NotEnoughFoundsException 
     */
    public void computeManagementFees(final int usrID) throws WrongAccountHolderException, NotEnoughFoundsException {
        final double feeAmount = MANAGEMENT_FEE + (totalTransactionCount * StrictBankAccount.TRANSACTION_FEE);
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
                balance -= MANAGEMENT_FEE + totalTransactionCount * StrictBankAccount.TRANSACTION_FEE;
                totalTransactionCount = 0;
        }
    }

    private boolean checkUser(final int id) throws WrongAccountHolderException {
        if(this.usrID != id) {
            throw new WrongAccountHolderException(this.usrID, id);
        } else {
            return this.usrID == id;
        }
    }

    private boolean isWithdrawAllowed(final double amount) throws NotEnoughFoundsException {
        if(getBalance() < amount) {
            throw new NotEnoughFoundsException(this.balance, amount);
        }
        return balance > amount;
    }

    private void increaseTransactionsCount() {
        totalTransactionCount++;
    }
}
