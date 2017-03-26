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


public class GUI extends JPanel implements ActionListener, MouseListener
{

    private final ParkingSpace[] parkingSpaces = new ParkingSpace[16];
    
    public GUI()
    {   
        clearSpaces();        
        buildGUI();
    }
    
    private void clearSpaces()
    {
        for (int i = 0; i < 16; i++)
        {
            parkingSpaces[i] = new ParkingSpace(i, this);
        }        
    }    
    
    private void buildGUI()
    {   
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(650, 600));
        
        SideMenu menu = new SideMenu(this);
        this.add(menu, BorderLayout.WEST);
        
        ParkingGrid grid = new ParkingGrid(parkingSpaces);
        this.add(grid, BorderLayout.EAST); 
    }
    
    private boolean largeSpacesFull()
    {
        for (int i = 0; i < 4; i++)
        {
            if (parkingSpaces[i].isEmpty())
                return false;
        }
        
        return true;
    }
    
    private boolean standardSpacesFull()
    {
        for (int i = 4; i < 16; i++)
        {
            if (parkingSpaces[i].isEmpty())
                return false;
        }
        
        return true;
    }
    
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
        if (e.getActionCommand().equals("Add Car"))
        {
            if (!standardSpacesFull())
            {
                parkingSpaces[nextAvailableStandardSpace()].update(new Car("VK11LML", 1.2, false, 5));
            }
            else
            {
                JOptionPane.showMessageDialog(this, "There are no available empty spaces!", "Car Park Full", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getActionCommand().equals("Add Lorry"))
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
        else if (e.getActionCommand().equals("Clear All"))
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
