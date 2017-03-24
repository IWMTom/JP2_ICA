package car.parking;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class VehicleDetails extends JFrame
{
    Vehicle data;
    
    public VehicleDetails(Vehicle data)
    {     
        this.data = data;
        buildGUI();        
    }
    
    private void buildGUI()
    {
        this.setTitle("Vehicle Details");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        
        JPanel padding = new JPanel();
        padding.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel details = new JLabel(data.toString());
        padding.add(details);
        
        this.add(padding);
        this.pack();
        this.setLocationRelativeTo(null);        
    }

}
