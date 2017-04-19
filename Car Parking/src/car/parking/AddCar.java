package car.parking;

import static car.parking.CarParking.tryParseDouble;
import static car.parking.CarParking.tryParseInteger;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class AddCar extends JDialog implements ActionListener
{

    JTextField regNo, length, hours;
    JCheckBox disabledBadge;
    
    String data_regNo;
    double data_length;
    int data_hours;
    boolean data_disabledBadge = false;
    
    boolean valid;
    
    public AddCar()
    {
        buildGUI();
    }
    
    private void buildGUI()
    {
        this.setTitle("Add Car");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        JPanel padding = new JPanel();
        padding.setBorder(new EmptyBorder(10, 10, 10, 10));
        padding.setLayout(new BoxLayout(padding, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel("Add Car");
        title.setFont(new Font("Sans Serif", Font.BOLD, 16));
        padding.add(title);
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        padding.add(new JSeparator());
        padding.add(Box.createRigidArea(new Dimension(0, 10)));
        
        JLabel regNoLabel = new JLabel("Registration Number");
        padding.add(regNoLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        regNo = new JTextField(10);
        padding.add(regNo);
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        JLabel lengthLabel = new JLabel("Vehicle Length (metres)");
        padding.add(lengthLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        length = new JTextField(10);
        padding.add(length);
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        disabledBadge = new JCheckBox("Disabled Badge");
        padding.add(disabledBadge);
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        JLabel hoursLabel = new JLabel("Number of Hours");
        padding.add(hoursLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        hours = new JTextField(10);
        padding.add(hours);
        
        padding.add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton submit = new JButton("Submit");
        submit.addActionListener(this);
        padding.add(submit);
        
        this.add(padding);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (regNo.getText().equals("") || length.getText().equals("") || hours.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "You must fill out all the fields!", "Missing Field", JOptionPane.ERROR_MESSAGE);
        }
        else if (tryParseDouble(length.getText()) == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Length must be a valid number", "Invalid Length", JOptionPane.ERROR_MESSAGE);
        }
        else if (tryParseInteger(hours.getText()) == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Number of hours must be a whole number", "Invalid Hours", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            data_regNo = regNo.getText();
            data_length = Double.parseDouble(length.getText());
            
            if (disabledBadge.isSelected())
            {
                data_disabledBadge = true;
            }
            
            data_hours = Integer.parseInt(hours.getText());
            
            valid = true;
            
            this.setVisible(false);
        }
    }
    
}
