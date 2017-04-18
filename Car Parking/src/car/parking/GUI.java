package car.parking;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * GUI.java
 * An extension of JPanel used to contain all the major GUI
 * for the application, as well as the Button / Mouse action logic.
 * 
 * @author Tom Wilson - S6051830
 */
public class GUI extends JPanel implements ActionListener, MouseListener
{

    private final ParkingSpace[] parkingSpaces = new ParkingSpace[16];
    private double currentTotal = 0.0;
    private double overallTotal = 0.0;
    
    public GUI()
    {   
        clearSpaces();        
        buildGUI();
    }

    /**
     * Initialises the array of type ParkingSpace to
     * empty objects with incrementing indexes
     */    
    private void clearSpaces()
    {
        for (int i = 0; i < 16; i++)
        {
            parkingSpaces[i] = new ParkingSpace(i, this);
        }        
    }    

    /**
     * Implements the core GUI logic for this class
     */      
    private void buildGUI()
    {   
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(650, 600));
        
        SideMenu menu = new SideMenu(this);
        this.add(menu, BorderLayout.WEST);
        
        ParkingGrid grid = new ParkingGrid(parkingSpaces);
        this.add(grid, BorderLayout.EAST); 
    }

    /**
     * Checks to see if the large spaces are full
     * 
     * @return boolean True if full, false if not
     */      
    private boolean largeSpacesFull()
    {
        for (int i = 0; i < 4; i++)
        {
            if (parkingSpaces[i].isEmpty())
                return false;
        }
        
        return true;
    }

    /**
     * Checks to see if the standard spaces are full
     * 
     * @return boolean True if full, false if not
     */       
    private boolean standardSpacesFull()
    {
        for (int i = 4; i < 16; i++)
        {
            if (parkingSpaces[i].isEmpty())
                return false;
        }
        
        return true;
    }

    /**
     * Locates the first available empty large space
     * 
     * Precondition is that largeSpacesFull() be checked prior
     * to this method, to prevent data being overwritten
     * 
     * @return int Index of next available large space
     */       
    private int nextAvailableLargeSpace()
    {
        int space = 0;
        
        for (int i = 0; i < 4; i++)
        {
            if (parkingSpaces[i].isEmpty())
            {
                space = i;
                break;
            }
        }        
        
        return space;
    }

    /**
     * Locates the first available empty standard space
     * 
     * Precondition is that standardSpacesFull() be checked prior
     * to this method, to prevent data being overwritten
     * 
     * @return int Index of next available standard space
     */      
    private int nextAvailableStandardSpace()
    {
        int space = 0;
        
        for (int i = 4; i < 16; i++)
        {
            if (parkingSpaces[i].isEmpty())
            {
                space = i;
                break;
            }
        }        
        
        return space;        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand();
        
        switch (actionCommand)
        {
            case "Add Car":         addCar();
                                    break;
            case "Add Lorry":       addLorry();
                                    break;
            case "Clear All":       clearAll();
                                    break;
            case "Current Total":   currentTotal();
                                    break;
            case "Total for Day":   totalForDay();
                                    break;
        }
    }

    /**
     * Adds a Car
     */      
    private void addCar()
    {
        if (!standardSpacesFull())
        {
            AddCar newCarWindow = new AddCar();
            Car newCar = new Car(newCarWindow.data_regNo, newCarWindow.data_length, newCarWindow.data_disabledBadge, newCarWindow.data_hours);
            
            currentTotal += newCar.getCharge();
            overallTotal += newCar.getCharge();
            
            parkingSpaces[nextAvailableStandardSpace()].update(newCar);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "There are no available empty spaces!", "Car Park Full", JOptionPane.ERROR_MESSAGE);
        }        
    }

    /**
     * Adds a Lorry
     */     
    private void addLorry()
    {
        if (!largeSpacesFull())
        {
            parkingSpaces[nextAvailableLargeSpace()].update(new Lorry("VK11LML", 25, 2));
        }
        else
        {
            JOptionPane.showMessageDialog(this, "There are no available empty spaces!", "Car Park Full", JOptionPane.ERROR_MESSAGE);
        }        
    }

    /**
     * Prompts the user to confirm, then clears all 
     * ParkingSpaces and redraws the grid
     */      
    private void clearAll()
    {
        if (JOptionPane.showConfirmDialog(this, "This will clear all data! Are you sure that you wish to continue?", "Are you sure?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            this.clearSpaces();
            this.removeAll();
            this.buildGUI();
            this.revalidate();
            this.repaint();
        }        
    }
    
    private void currentTotal()
    {
        JOptionPane.showMessageDialog(this, "The total income for all current vehicles is: £" + String.format("%1$.2f", currentTotal));
    }
    
    private void totalForDay()
    {
        JOptionPane.showMessageDialog(this, "The overall total income is: £" + String.format("%1$.2f", overallTotal));
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getSource() instanceof ParkingSpace)
        {
            ParkingSpace currentSelection = (ParkingSpace) e.getSource();
            
            if (!currentSelection.isEmpty())
            {
                if (SwingUtilities.isRightMouseButton(e))
                {
                    if (JOptionPane.showConfirmDialog(this, "Do you wish to remove this vehicle?", "Confirm Removal", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        currentTotal -= parkingSpaces[currentSelection.index].data.getCharge();
                        parkingSpaces[currentSelection.index].delete();
                    }
                }     
                else if (SwingUtilities.isLeftMouseButton(e))
                {
                    VehicleDetails details = new VehicleDetails(parkingSpaces[currentSelection.index].data);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(currentSelection, "This space is empty!", "Space Empty", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}
    
}
