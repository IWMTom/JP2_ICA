package car.parking;

import java.awt.Dialog;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * VehicleDetails.java
 * Displays the details of a selected vehicle to the user
 * @author Tom Wilson - S6051830
 */
public class VehicleDetails extends JDialog
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
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        JPanel padding = new JPanel();
        padding.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel details = new JLabel(data.toString());
        padding.add(details);
        
        this.add(padding);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
    }

}
