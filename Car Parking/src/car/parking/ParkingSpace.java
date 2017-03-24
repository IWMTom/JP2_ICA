package car.parking;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ParkingSpace extends JButton
{
   
    VehicleType type;
    Vehicle data;
    int index;
    
    public enum VehicleType {CAR, LORRY, COACH}
    
    ParkingSpace(int index, MouseListener mListener)
    {
        this.setBackground(null);
        this.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 0, Color.red));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));      
        this.addMouseListener(mListener);
        
        this.type = null;
        this.data = null;
        this.index = index;
    }
    
    public void update(VehicleType t, Vehicle d)
    {
        this.type = t;
        this.data = d;
        
        if (d != null)
            this.setIcon(d.getImage());
    }
    
    public void delete()
    {
        this.type = null;
        this.data = null;
        this.setIcon(null);
    }
}