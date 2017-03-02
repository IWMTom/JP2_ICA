package car.parking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.io.*;

public class ParkingGrid extends JPanel implements ActionListener
{

    public ParkingGrid()
    {
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
            JButton space = new JButton();
            space.setBackground(null);
            space.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 0, Color.red));
            
            if (i == 0)
            {
                space.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.red));
                space.setIcon(new ImageIcon("images/lorry.png"));
            }
            
            if (i == 1)
            {
                space.setIcon(new ImageIcon("images/coach.png"));
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
        
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 4; y++)
            {
                JButton space = new JButton();
                space.setBackground(null);
                space.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 0, Color.red));
                
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
                
                if (x == 0 && y == 0)
                {
                    space.setIcon(new ImageIcon("images/car.png"));
                }
                
                if (x == 0 && y == 3)
                {
                    space.setIcon(new ImageIcon("images/campervan.png"));
                }
                
                standardSpaces.add(space);
            }    
        }        
        
        this.add(standardSpaces, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
