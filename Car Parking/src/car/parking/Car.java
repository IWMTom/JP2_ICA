package car.parking;

import javax.swing.ImageIcon;

/**
 * Car.java
 * A subclass of Vehicle for Cars
 * @author Tom Wilson - S6051830
 */
public class Car extends Vehicle
{
    
    private double length;
    private boolean disabledBadge;
    private int numOfHours;

    /**
     * Default class constructor
     */
    public Car()
    {
        this.length = 0;
        this.disabledBadge = false;
        this.numOfHours = 0;
    }

    /**
     * Class constructor specifying inputted data then calculating charge
     * 
     * @param rn Vehicle Registration Number
     * @param l Length
     * @param disBadge Disabled Badge Holder
     * @param hours Number of Hours
     */
    public Car(String rn, double l, boolean disBadge, int hours)
    {
        this.regNumber = rn;
        this.length = l;
        this.disabledBadge = disBadge;
        this.numOfHours = hours;
        
        calcCharge();
    }
    
    /**
     * Gets Car length
     * @return Length
     */
    public double getLength()
    {
        return length;
    }
    
    @Override
    public String toString()
    {
        return regNumber + "," + charge + "," + length;
    }

    @Override
    public ImageIcon getImage()
    {
        return new ImageIcon(); // TODO
    }

    /**
     * Calculates the vehicle charge
     * This method is always called when the class is constructed.
     * It overrides the abstract method inherited from Vehicle.
     * @return Vehicle Charge
     */
    @Override
    public double calcCharge()
    {
        if (disabledBadge)
        {
            charge = 0.00;
        }
        else
        {
            if (length > 6)
            {
                charge = 1.50;
            }
            else
            {
                charge = 1.00;
            }
        }
        
        charge = charge * numOfHours;
        
        return charge;
    }

}
