package car.parking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class ParkingGrid extends JPanel
{

    private final ParkingSpace[] parkingSpaces;

    public ParkingGrid(ParkingSpace[] parkingSpaces)
    {
        this.parkingSpaces = parkingSpaces;
        buildGUI();
    }
    
    private void buildGUI()
    {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 600));    
        
        buildLargeSpaces();
        buildStandardSpaces();
    }
    
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
                space.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.red));
            }

            largeSpaces.add(space);
        }
        
        this.add(largeSpaces, BorderLayout.NORTH);
    }
    
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
                    space.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.red));
                }                
                
                if (x == 2)
                {
                    space.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.red));
                }
                
                if (x == 2 && y == 0)
                {
                    space.setBorder(null);
                }
                
                standardSpaces.add(space);
                i++;
            }    
        }        
        
        this.add(standardSpaces, BorderLayout.SOUTH);
    }
    
}
