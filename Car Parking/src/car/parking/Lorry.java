package car.parking;

import javax.swing.ImageIcon;

/**
 * Lorry.java
 * A subclass of Vehicle for Lorries
 * @author Tom Wilson - S6051830
 */
public class Lorry extends Vehicle
{

    private double weight;
    private int numOfDays;

    /**
     * Default class constructor
     */
    public Lorry()
    {
        this.weight = 0.0;
        this.numOfDays = 0;
    }

    /**
     * Class constructor specifying inputted data then calculating charge
     * 
     * @param rn Vehicle Registration Number
     * @param w Weight
     * @param days Number of Days
     */
    public Lorry(String rn, double w, int days)
    {
        this.regNumber = rn;
        this.weight = w;
        this.numOfDays = days;
        
        calcCharge();
    }
    
    /**
     * Gets Lorry weight
     * @return Weight
     */
    public double getWeight()
    {
        return weight;
    }
    
    public void setWeight(double w)
    {
        weight = w;
    }
    
    public int getDays()
    {
        return numOfDays;
    }
    
    public void setDays(int d)
    {
        numOfDays = d;
    }
    
    @Override
    public String toString()
    {
        return "Registration Number: " + regNumber + " | Charge: £" + String.format("%1$.2f", charge) + " | Weight: " + weight + " tonnes";
    }
    
    @Override
    public ImageIcon getImage()
    {
        return new ImageIcon("images/lorry.png");      
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
        if (weight < 20)
        {
            charge = 5.00;
        }
        else if (weight >= 20 && weight <= 35)
        {
            charge = 8.00;
        }
        
        charge = charge * numOfDays;
        
        return charge;
    }

}
