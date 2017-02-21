/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car.parking;

import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom
 */
public class VehicleTest
{
    
    public VehicleTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getCharge method, of class Vehicle.
     */
    @Test
    public void testGetCharge()
    {
        System.out.println("getCharge");
        Vehicle instance = new VehicleImpl();
        double expResult = 0.0;
        double result = instance.getCharge();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Vehicle.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Vehicle instance = new VehicleImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImage method, of class Vehicle.
     */
    @Test
    public void testGetImage()
    {
        System.out.println("getImage");
        Vehicle instance = new VehicleImpl();
        ImageIcon expResult = null;
        ImageIcon result = instance.getImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcCharge method, of class Vehicle.
     */
    @Test
    public void testCalcCharge()
    {
        System.out.println("calcCharge");
        Vehicle instance = new VehicleImpl();
        double expResult = 0.0;
        double result = instance.calcCharge();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class VehicleImpl extends Vehicle
    {

        public ImageIcon getImage()
        {
            return null;
        }

        public double calcCharge()
        {
            return 0.0;
        }
    }
    
}
