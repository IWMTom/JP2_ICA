package car.parking;


public class CarParking
{

    public static void main(String[] args)
    {
        System.out.println();
        
        System.out.println("Car #1");
        System.out.println("----------------------------");
        Car car1 = new Car("BF61YTJ", 4.1, false, 5);
        System.out.println("Charge: " + car1.getCharge());
        System.out.println("Output: " + car1.toString());
        
        System.out.println();
        
        System.out.println("Car #2");
        System.out.println("----------------------------");
        Car car2 = new Car("VK11LML", 6.2, true, 1);
        System.out.println("Charge: " + car2.getCharge());
        System.out.println("Output: " + car2.toString());
        
        System.out.println();
        
        System.out.println("Lorry #1");
        System.out.println("----------------------------");
        Lorry lorry1 = new Lorry("MS61JFK", 14.15, 5);
        System.out.println("Charge: " + lorry1.getCharge());
        System.out.println("Output: " + lorry1.toString());
        
        System.out.println();
        
        System.out.println("Lorry #2");
        System.out.println("----------------------------");
        Lorry lorry2 = new Lorry("NU54JAH", 28.5, 3);
        System.out.println("Charge: " + lorry2.getCharge());
        System.out.println("Output: " + lorry2.toString());
        
        System.out.println();
        
        System.out.println("Coach #1");
        System.out.println("----------------------------");
        Coach coach1 = new Coach ("NV07XPD", 25, true);
        System.out.println("Charge: " + coach1.getCharge());
        System.out.println("Output: " + coach1.toString());
        
        System.out.println();
        
        System.out.println("Coach #2");
        System.out.println("----------------------------");
        Coach coach2 = new Coach ("LK61KAU", 15, false);
        System.out.println("Charge: " + coach2.getCharge());
        System.out.println("Output: " + coach2.toString());
        
    }

}
