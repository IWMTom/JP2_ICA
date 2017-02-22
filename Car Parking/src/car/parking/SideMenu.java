package car.parking;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class SideMenu extends JPanel implements ActionListener
{

    public SideMenu()
    {
        buildGUI();
    }
    
    private void buildGUI()
    {
        this.setLayout(new GridLayout(0,1));
        this.setPreferredSize(new Dimension(150, 600));
        
        JButton addCar = new JButton("Add Car");
        this.add(addCar);
        
        JButton addLorry = new JButton("Add Lorry");
        this.add(addLorry);
        
        JButton addCoach = new JButton("Add Coach");
        this.add(addCoach);    
        
        JButton clearAll = new JButton("Clear All");
        this.add(clearAll);
        
        JButton save = new JButton("Save");
        this.add(save);
        
        JButton load = new JButton("Load");
        this.add(load);
        
        JButton currentTotal = new JButton("Current Total");
        this.add(currentTotal);
        
        JButton totalForDay = new JButton("Total for Day");
        this.add(totalForDay);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
