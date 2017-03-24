package car.parking;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class SideMenu extends JPanel
{
    private final ActionListener listener;
    
    public SideMenu(ActionListener listener)
    {
        this.listener = listener;
        buildGUI();
    }
    
    private void buildGUI()
    {
        this.setLayout(new GridLayout(0,1));
        this.setPreferredSize(new Dimension(150, 600));
        
        JButton addCar = new JButton("Add Car");
        addCar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addCar.addActionListener(listener);
        this.add(addCar);
        
        JButton addLorry = new JButton("Add Lorry");
        addLorry.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addLorry.addActionListener(listener);
        this.add(addLorry);
        
        JButton addCoach = new JButton("Add Coach");
        addCoach.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addCoach.addActionListener(listener);
        this.add(addCoach);    
        
        JButton clearAll = new JButton("Clear All");
        clearAll.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearAll.addActionListener(listener);
        this.add(clearAll);
        
        JButton save = new JButton("Save");
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
        save.addActionListener(listener);
        this.add(save);
        
        JButton load = new JButton("Load");
        load.setCursor(new Cursor(Cursor.HAND_CURSOR));
        load.addActionListener(listener);
        this.add(load);
        
        JButton currentTotal = new JButton("Current Total");
        currentTotal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        currentTotal.addActionListener(listener);
        this.add(currentTotal);
        
        JButton totalForDay = new JButton("Total for Day");
        totalForDay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        totalForDay.addActionListener(listener);
        this.add(totalForDay);
    }

}
