package car.parking;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CarParking
{

    public static void main(String[] args)
    {

        JFrame mainWindow = new JFrame("Car Parking System");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(700, 600);
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);
        
        JPanel base = new JPanel(new BorderLayout());
        
        SideMenu menu = new SideMenu();
        base.add(menu, BorderLayout.WEST);
        
        ParkingGrid grid = new ParkingGrid();
        base.add(grid, BorderLayout.EAST);
        
        mainWindow.add(base);
        
    }

}
