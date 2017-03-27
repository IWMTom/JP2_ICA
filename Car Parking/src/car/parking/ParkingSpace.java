package car.parking;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * ParkingSpace.java
 * An extension of JButton used to store and display the 
 * contents of any given parking space in the car park
 * 
 * @author Tom Wilson - S6051830
 */
public class ParkingSpace extends JButton
{
    
    Vehicle data;
    int index;

    /**
     * Class constructor
     * 
     * @param index Index within an array of parking spaces
     * @param mListener MouseListener from the parent class
     */    
    ParkingSpace(int index, MouseListener mListener)
    {   
        this.data = null;
        this.index = index;
        
        buildGUI(mListener);
    }

    /**
     * Implements the core GUI logic for this class
     * 
     * @param mListener MouseListener from the parent class
     */        
    private void buildGUI(MouseListener mListener)
    {
        this.setBackground(null);
        this.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 0, Color.red));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));      
        this.addMouseListener(mListener);        
    }

    /**
     * Tests whether the ParkingSpace is empty
     * 
     * @return boolean True if empty, false if not
     */       
    public boolean isEmpty()
    {
        if (this.data == null)
        {
            return true;
        }
        else
        {
            return false;            
        }
    }

    /**
     * Updates the ParkingSpace to contain a Vehicle
     * 
     * @param d Any Vehicle Type
     */     
    public void update(Vehicle d)
    {
        this.data = d;
        
        if (d != null)
        {
            this.setIcon(d.getImage());
        }
    }

    /**
     * Deletes the contents of the ParkingSpace
     */      
    public void delete()
    {
        this.data = null;
        this.setIcon(null);
    }
}