package car.parking;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ParkingSpace extends JButton
{
    
    Vehicle data;
    int index;
    
    ParkingSpace(int index, MouseListener mListener)
    {   
        this.data = null;
        this.index = index;
        
        buildGUI(mListener);
    }
    
    private void buildGUI(MouseListener mListener)
    {
        this.setBackground(null);
        this.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 0, Color.red));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));      
        this.addMouseListener(mListener);        
    }
    
    public void update(Vehicle d)
    {
        this.data = d;
        
        if (d != null)
            this.setIcon(d.getImage());
    }
    
    public void delete()
    {
        this.data = null;
        this.setIcon(null);
    }
}