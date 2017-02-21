package car.parking;

import javax.swing.ImageIcon;

/**
 * Coach.java
 * A subclass of Vehicle for Coaches
 * @author Tom Wilson - S6051830
 */
public class Coach extends Vehicle
{

    private int numOfPassengers;
    private boolean touristOperator;
    
    /**
     * Default class constructor
     */
    public Coach()
    {
        this.numOfPassengers = 0;
        this.touristOperator = false;
    }

    /**
     * Class constructor specifying inputted data then calculating charge
     * 
     * @param rn Vehicle Registration Number
     * @param np Number of Passengers
     * @param touristOp Is a Tourist Operator?
     */
    public Coach(String rn, int np, boolean touristOp)
    {
        this.regNumber = rn;
        this.numOfPassengers = np;
        this.touristOperator = touristOp;
        
        calcCharge();
    }

    @Override
    public String toString()
    {
        return regNumber + "," + charge + "," + numOfPassengers;
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
        if (numOfPassengers > 20)
        {
            charge = 6.00;
        }
        else
        {
            charge = 4.50;
        }
        
        if (touristOperator)
        {
            charge = charge * 0.9;
        }
        
        return charge;
    }

}
