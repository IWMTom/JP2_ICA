package car.parking;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class AddLorry extends JDialog implements ActionListener
{

    JTextField regNo, weight, days;
    
    String data_regNo;
    double data_weight;
    int data_days;
    
    boolean valid;
    
    public AddLorry()
    {
        buildGUI();
    }
    
    private void buildGUI()
    {
        this.setTitle("Add Lorry");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        JPanel padding = new JPanel();
        padding.setBorder(new EmptyBorder(10, 10, 10, 10));
        padding.setLayout(new BoxLayout(padding, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel("Add Lorry");
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
        
        JLabel weightLabel = new JLabel("Vehicle Weight (tonnes)");
        padding.add(weightLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        weight = new JTextField(10);
        padding.add(weight);
        
        padding.add(Box.createRigidArea(new Dimension(0, 5)));
        
        JLabel daysLabel = new JLabel("Number of Days");
        padding.add(daysLabel);
        padding.add(Box.createRigidArea(new Dimension(0, 2)));
        days = new JTextField(10);
        padding.add(days);
        
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
        if (regNo.getText().equals("") || weight.getText().equals("") || days.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "You must fill out all the fields!", "Missing Field", JOptionPane.ERROR_MESSAGE);
        }
        else if (tryParseDouble(weight.getText()) == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Weight must be a valid number", "Invalid Weight", JOptionPane.ERROR_MESSAGE);
        }
        else if (tryParseInteger(days.getText()) == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Number of days must be a whole number", "Invalid Days", JOptionPane.ERROR_MESSAGE);
        }
        else if (tryParseDouble(weight.getText()) > 35)
        {
            JOptionPane.showMessageDialog(rootPane, "Weight cannot be above 35 tonnes", "Invalid Weight", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            data_regNo = regNo.getText();
            data_weight = Double.parseDouble(weight.getText());
            data_days = Integer.parseInt(days.getText());
            
            valid = true;
            
            this.setVisible(false);
        }
    }
    
    public Double tryParseDouble(String data)
    {
        try
        {
            return Double.parseDouble(data);
        }
        catch (NumberFormatException e)
        {
            return null;
        }       
    }
    
    public Integer tryParseInteger(String data)
    {
        try
        {
            return Integer.parseInt(data);
        }
        catch (NumberFormatException e)
        {
            return null;
        }       
    }
    
}
