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

    
    /**
     * Tests if a string can be converted to an integer
     * @param data Data to be parsed
     * @return Integer if parsed, or null if failed
     */    
    public static Integer tryParseInteger(String data)
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

    /**
     * Tests if a string can be converted to an double
     * @param data Data to be parsed
     * @return Double if parsed, or null if failed
     */     
    public static Double tryParseDouble(String data)
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
    
}
