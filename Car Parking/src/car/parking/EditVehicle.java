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

/**
 * EditVehicle.java
 * Allows the user to edit the details of a Vehicle
 * @author Tom Wilson - S6051830
 */
public class EditVehicle extends JDialog implements ActionListener
{
    Vehicle data;
    
    JTextField regNo, length, hours, passengers, weight, days;
    JCheckBox disabledBadge, touristOperator;
    
    public EditVehicle(Vehicle data)
    {     
        this.data = data;
        
        buildGUI();        
    }
    
    private void buildGUI()
    {
        this.setTitle("Edit Vehicle");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        JPanel padding = new JPanel();
        padding.setBorder(new EmptyBorder(10, 10, 10, 10));
        padding.setLayout(new BoxLayout(padding, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel("Edit Vehicle");
        title.setFont(new Font("Sans Serif", Font.BOLD, 16));
        padding.add(title);
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        padding.add(new JSeparator());
        padding.add(Box.createRigidArea(new Dimension(0, 10)));
        
        JLabel regNoLabel = new JLabel("Registration Number");
        padding.add(regNoLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        regNo = new JTextField(data.regNumber);
        padding.add(regNo);
        
        if (data instanceof Car)
        {
            buildCarGUI(padding);
        }
        else if (data instanceof Coach)
        {
            buildCoachGUI(padding);
        }
        else if (data instanceof Lorry)
        {
            buildLorryGUI(padding);
        }    
        
        padding.add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton save = new JButton("Save");
        save.addActionListener(this);
        padding.add(save);
        
        this.add(padding);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
    }
    
    private void buildCarGUI(JPanel padding)
    {
        Car current = (Car)data;
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        JLabel lengthLabel = new JLabel("Vehicle Length (metres)");
        padding.add(lengthLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        length = new JTextField(Double.toString(current.getLength()), 10);
        padding.add(length);
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        disabledBadge = new JCheckBox("Disabled Badge");
        
        if (current.getDisabledBadge())
        {
            disabledBadge.setSelected(true);
        }
            
        padding.add(disabledBadge);
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        JLabel hoursLabel = new JLabel("Number of Hours");
        padding.add(hoursLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        hours = new JTextField(Integer.toString(current.getHours()));
        padding.add(hours);        
    }
    
    private void buildCoachGUI(JPanel padding)
    {
        Coach current = (Coach)data;
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        touristOperator = new JCheckBox("Tourist Operator");
        
        if (current.getTouristOperator())
        {
            touristOperator.setSelected(true);
        }
        
        padding.add(touristOperator);
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        JLabel passengersLabel = new JLabel("Number of Passengers");
        padding.add(passengersLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        passengers = new JTextField(Integer.toString(current.getPassengers()), 10);
        padding.add(passengers);        
    }

    private void buildLorryGUI(JPanel padding)
    {
        Lorry current = (Lorry)data;
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        JLabel weightLabel = new JLabel("Vehicle Weight (tonnes)");
        padding.add(weightLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        weight = new JTextField(Double.toString(current.getWeight()), 10);
        padding.add(weight);
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        JLabel daysLabel = new JLabel("Number of Days");
        padding.add(daysLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        days = new JTextField(Integer.toString(current.getDays()), 10);
        padding.add(days);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        data.setRegistration(regNo.getText());
        
        if (data instanceof Car)
        {
            if (regNo.getText().equals("") || length.getText().equals("") || hours.getText().equals("")) // Checks if all fields have been entered
            {
                JOptionPane.showMessageDialog(rootPane, "You must fill out all the fields!", "Missing Field", JOptionPane.ERROR_MESSAGE);
            }
            else if (tryParseDouble(length.getText()) == null) // Checks if length is a valid number
            {
                JOptionPane.showMessageDialog(rootPane, "Length must be a valid number", "Invalid Length", JOptionPane.ERROR_MESSAGE);
            }
            else if (tryParseInteger(hours.getText()) == null) // Checks if hours is a valid integer
            {
                JOptionPane.showMessageDialog(rootPane, "Number of hours must be a whole number", "Invalid Hours", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                ((Car)data).setLength(Double.parseDouble(length.getText()));
                ((Car)data).setDisabledBadge(disabledBadge.isSelected());
                ((Car)data).setHours(Integer.parseInt(hours.getText()));
                
                dispose();
            }
        }
        else if (data instanceof Coach)
        {
            if (regNo.getText().equals("") || passengers.getText().equals("")) // Checks if all fields have been entered
            {
                JOptionPane.showMessageDialog(rootPane, "You must fill out all the fields!", "Missing Field", JOptionPane.ERROR_MESSAGE);
            }
            else if (tryParseInteger(passengers.getText()) == null) // Checks if passengers is a valid integer
            {
                JOptionPane.showMessageDialog(rootPane, "Number of passengers must be a whole number", "Invalid Passengers", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                ((Coach)data).setTouristOperator(touristOperator.isSelected());
                ((Coach)data).setPassengers(Integer.parseInt(passengers.getText()));   
                
                dispose();
            } 
        }
        else if (data instanceof Lorry)
        {
            if (regNo.getText().equals("") || weight.getText().equals("") || days.getText().equals("")) // Checks if all fields have been entered
            {
                JOptionPane.showMessageDialog(rootPane, "You must fill out all the fields!", "Missing Field", JOptionPane.ERROR_MESSAGE);
            }
            else if (tryParseDouble(weight.getText()) == null) // Checks if weight is a valid number
            {
                JOptionPane.showMessageDialog(rootPane, "Weight must be a valid number", "Invalid Weight", JOptionPane.ERROR_MESSAGE);
            }
            else if (tryParseInteger(days.getText()) == null) // Checks if days is a valid integer
            {
                JOptionPane.showMessageDialog(rootPane, "Number of days must be a whole number", "Invalid Days", JOptionPane.ERROR_MESSAGE);
            }
            else if (tryParseDouble(weight.getText()) > 35) // Checks if weight is below 35 tonnes
            {
                JOptionPane.showMessageDialog(rootPane, "Weight cannot be above 35 tonnes", "Invalid Weight", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                ((Lorry)data).setWeight(Double.parseDouble(weight.getText()));
                ((Lorry)data).setDays(Integer.parseInt(days.getText()));  
                
                dispose();
            }            
        }   
    }
    
}
