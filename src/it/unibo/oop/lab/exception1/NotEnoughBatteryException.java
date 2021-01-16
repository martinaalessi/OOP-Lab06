/**
 * 
 */
package it.unibo.oop.lab.exception1;

/**
 * @author marti
 *
 */
public class NotEnoughBatteryException extends Exception {

    private static final long serialVersionUID = 1L;
    private double batteryLevel;
    private double batteryRequired;

    public NotEnoughBatteryException(double batteryLevel, double batteryRequired) {
        super();
        this.batteryLevel = batteryLevel;
        this.batteryRequired = batteryRequired;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "NotEnoughBatteryException [batteryLevel=" + batteryLevel + ", batteryRequired=" + batteryRequired + "]";
    }
    
    

}
