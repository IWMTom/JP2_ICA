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

    /**
     * Gets Tourist Operator
     * @return Tourist Operator
     */    
    public boolean getTouristOperator()
    {
        return touristOperator;
    }

    /**
     * Sets Tourist Operator
     * @param to Tourist Operator
     */        
    public void setTouristOperator(boolean to)
    {
        touristOperator = to;
    }

    /**
     * Gets Number of Passengers
     * @return Number of Passengers
     */     
    public int getPassengers()
    {
        return numOfPassengers;
    }

    /**
     * Sets Number of Passengers
     * @param p Number of Passengers
     */        
    public void setPassengers(int p)
    {
        numOfPassengers = p;
    }
    
    @Override
    public String toString()
    {
        return "Registration Number: " + regNumber + " | Charge: £" + String.format("%1$.2f", charge) + " | Number of Passengers: " + numOfPassengers;
    }
    
    @Override
    public ImageIcon getImage()
    {
        return new ImageIcon("images/coach.png");
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
