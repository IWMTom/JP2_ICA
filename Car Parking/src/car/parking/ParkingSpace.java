package car.parking;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ParkingSpace extends JButton implements ActionListener
{
   
    VehicleType type;
    Vehicle data;
    
    public enum VehicleType {CAR, LORRY, COACH}
    
    ParkingSpace(VehicleType t, Vehicle d)
    {
        this.setBackground(null);
        this.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 0, Color.red));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));      
        this.addActionListener(this);
        
        if (d != null)
            this.setIcon(d.getImage());
        
        this.type = t;
        this.data = d;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this)
        {
            JOptionPane.showMessageDialog(this, data.toString());
        }
    }
}