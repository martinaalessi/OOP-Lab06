package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
        final AccountHolder m1 = new AccountHolder("Martina", "Alessi", 1);
        final AccountHolder f1 = new AccountHolder("Fabio", "Ciotoli", 2);
        final StrictBankAccount m2 = new StrictBankAccount(1, 1000, 2);
        final StrictBankAccount f2 = new StrictBankAccount(2, 5000, 10);
        
        assertEquals(m2.getTransactionCount(), 0);
        try {
            for(int i=0; i<2; i++) {
                m2.withdrawFromATM(1, 100);
            }
            m2.withdrawFromATM(1, 100);
            fail("ATM transactions gets over the maximum allowed.");
        } catch(TransactionsOverQuotaException e) {
            Assert.assertNotNull(e.getMessage());
        } catch(NotEnoughFoundsException e) {
            fail("No founds problem expected here.");
        } catch(WrongAccountHolderException e) {
            fail("No wrong account holder expected here");
        } 
        
        assertEquals(m1.getUserID(), Integer.valueOf(1));
        assertEquals(f1.getUserID(), Integer.valueOf(2));
        try {
            f2.withdrawFromATM(1, 200);
            fail("UserID is wrong.");
        } catch (WrongAccountHolderException e) {
            Assert.assertNotNull(e.getMessage());
        } catch(NotEnoughFoundsException e) {
            fail("No founds problem expected here.");
        } catch(TransactionsOverQuotaException e) {
            fail("No ATM transactions problem expected here.");
        }
        
        assertEquals(m2.getTransactionCount(), 2);
        try {
            m2.withdraw(1, 1500);
            fail("there is not enough money for a draw operation to complete.");
        } catch (NotEnoughFoundsException e) {
            Assert.assertNotNull(e.getMessage());
        } catch(WrongAccountHolderException e) {
            fail("No wrong account holder expected here");
        }
    }
}
