package car.parking;

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


public class AddCoach extends JDialog implements ActionListener
{

    JTextField regNo, passengers;
    JCheckBox touristOperator;
    
    String data_regNo;
    int data_passengers;
    boolean data_touristOperator = false;
    
    boolean valid;
    
    public AddCoach()
    {
        buildGUI();
    }
    
    private void buildGUI()
    {
        this.setTitle("Add Coach");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        JPanel padding = new JPanel();
        padding.setBorder(new EmptyBorder(10, 10, 10, 10));
        padding.setLayout(new BoxLayout(padding, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel("Add Coach");
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
        
        touristOperator = new JCheckBox("Tourist Operator");
        padding.add(touristOperator);
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        JLabel passengersLabel = new JLabel("Number of Passengers");
        padding.add(passengersLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        passengers = new JTextField(10);
        padding.add(passengers);
        
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
        if (regNo.getText().equals("") || passengers.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "You must fill out all the fields!", "Missing Field", JOptionPane.ERROR_MESSAGE);
        }
        else if (tryParseInteger(passengers.getText()) == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Number of passengers must be a whole number", "Invalid Passengers", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            data_regNo = regNo.getText();
            
            if (touristOperator.isSelected())
            {
                data_touristOperator = true;
            }
            
            data_passengers = Integer.parseInt(passengers.getText());
            
            valid = true;
            
            this.setVisible(false);
        }
    }
    
}
