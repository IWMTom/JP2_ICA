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
        
        parkingSpaces[2].update(ParkingSpace.VehicleType.COACH, new Coach("BF61YTJ", 5, false));
        
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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Clear All"))
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
            
            if (currentSelection.type != null)
            {
                if (SwingUtilities.isRightMouseButton(e))
                {
                    if (JOptionPane.showConfirmDialog(this, "Do you wish to remove this vehicle?", "Confirm Removal", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        parkingSpaces[currentSelection.index].delete();
                    }
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
