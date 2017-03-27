package car.parking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


/**
 * ParkingGrid.java
 * An extension of JPanel used to display all the
 * parking spaces in the car park, with 4 large spaces
 * and 12 standard spaces located underneath
 * 
 * @author Tom Wilson - S6051830
 */
public class ParkingGrid extends JPanel
{

    private final ParkingSpace[] parkingSpaces;

    /**
     * Class constructor
     * 
     * @param parkingSpaces Array of type ParkingSpace
     */
    public ParkingGrid(ParkingSpace[] parkingSpaces)
    {
        this.parkingSpaces = parkingSpaces;
        buildGUI();
    }

    /**
     * Implements the core GUI logic for this class
     */        
    private void buildGUI()
    {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 600));    
        
        buildLargeSpaces();
        buildStandardSpaces();
    }

    /**
     * Builds the large spaces by taking the first
     * 4 elements from the array parkingSpaces
     */        
    private void buildLargeSpaces()
    {
        JPanel largeSpaces = new JPanel(new GridLayout(1, 4));
        largeSpaces.setPreferredSize(new Dimension(500, 252));
        largeSpaces.setBackground(Color.white);
        
        for (int i = 0; i < 4; i++)
        {
            ParkingSpace space = parkingSpaces[i];
            
            if (i == 0)
            {
                // Removes left border for top left ParkingSpace
                space.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.red));
            }

            largeSpaces.add(space);
        }
        
        this.add(largeSpaces, BorderLayout.NORTH);
    }

    /**
     * Builds the standard spaces by taking the
     * remaining 12 elements from the array parkingSpaces
     */         
    private void buildStandardSpaces()
    {
        JPanel standardSpaces = new JPanel(new GridLayout(3, 4));
        standardSpaces.setPreferredSize(new Dimension(500, 348));
        standardSpaces.setBackground(Color.white);
        
        int i = 4;
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 4; y++)
            {
                ParkingSpace space = parkingSpaces[i];
                
                if (y == 0)
                {
                    // Removes left border for left hand side ParkingSpaces
                    space.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.red));
                }                
                
                if (x == 2)
                {
                    // Removes bottom border for bottom ParkingSpaces
                    space.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));
                }
                
                if (x == 2 && y == 0)
                {
                    // Removes all borders for bottom left ParkingSpace
                    space.setBorder(null);
                }
                
                standardSpaces.add(space);
                i++;
            }    
        }        
        
        this.add(standardSpaces, BorderLayout.SOUTH);
    }
    
}
