package car.parking;

import javax.swing.JFrame;

public class CarParking
{

    public static void main(String[] args)
    {
        JFrame mainWindow = new JFrame("Car Parking System");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        
        GUI base = new GUI();
        mainWindow.add(base);
        
        mainWindow.pack();  
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }

}
