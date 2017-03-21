package car.parking;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CarParking
{

    public static void main(String[] args)
    {

        JFrame mainWindow = new JFrame("Car Parking System");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);
        
        JPanel base = new JPanel(new BorderLayout());
        base.setPreferredSize(new Dimension(650, 600));
        
        SideMenu menu = new SideMenu();
        base.add(menu, BorderLayout.WEST);
        
        ParkingGrid grid = new ParkingGrid();
        base.add(grid, BorderLayout.EAST);
        
        mainWindow.add(base);
        mainWindow.pack();  
        mainWindow.setLocationRelativeTo(null);
    }

}
