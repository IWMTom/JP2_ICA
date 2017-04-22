package car.parking;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 * Vehicle.java
 * The abstract base class for all vehicle subtypes
 * @author Tom Wilson - S6051830
 */
public abstract class Vehicle implements Serializable
{
    
    protected double charge;
    protected String regNumber;

    /**
     * Default class constructor
     */
    public Vehicle()
    {
        this.charge = 0.0;
        this.regNumber = null;
    }
    
    /**
     * Class constructor taking Vehicle registration number
     * @param rn Vehicle Registration Number
     */
    public Vehicle(String rn)
    {
        this.regNumber = rn;
    }

    /**
     * Sets the Registration Number
     * @param rn Registration Number
     */    
    public void setRegistration(String rn)
    {
        regNumber = rn;
    }
    
    /**
     * Calculates the vehicle charge
     * @return Vehicle Charge
     */
    public double getCharge()
    {
        return charge;
    }
    
    @Override
    public String toString()
    {
        return regNumber + "," + charge;
    }
        
    abstract ImageIcon getImage();
    abstract double calcCharge();
}
