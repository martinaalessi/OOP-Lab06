/**
 * 
 */
package it.unibo.oop.lab.exception2;

/**
 * @author marti
 *
 */
public class WrongAccountHolderException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 7190620326792084901L;
    private final int usrID;
    private final int usrIDWrong;
    
    public WrongAccountHolderException(int usrID, int usrIDWrong) {
        super();
        this.usrID = usrID;
        this.usrIDWrong = usrIDWrong;
    }

    @Override
    public String toString() {
        return "WrongAccountHolderException [usrID=" + usrID + ", usrIDWrong=" + usrIDWrong + "]";
    }

    public String getMessage() {
        return toString();
    }
}
