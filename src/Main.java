import java.util.*;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static HashMap<String, Appliance> devices = new HashMap<>();

    // Add the devices in the HashMap
    public static void addDevices(){

    }

    // Show all devices and their status
    public static void showDevices(){
        System.out.println("*** Showing All Devices ***");
        for (Appliance device : devices.values()) {
            device.showDeviceStatus();
        }
    }

    // Turn ON a device
    public static void turnOn(String d){
        Appliance device = devices.get(d);
        if (device != null) {
            if (device.getStatus().equalsIgnoreCase("on")) {
                System.out.println(d + " is already ON.");
            } else {
                device.turnONdevice();
                System.out.println(d + " is now ON.");
            }
        } else {
            System.out.println("Device not found!");
        }
    }

    // Turn OFF a device
    public static void turnOff(String d){
        Appliance device = devices.get(d);
        if (device != null) {
            if (device.getStatus().equalsIgnoreCase("off")) {
                System.out.println(d + " is already OFF.");
            } else {
                device.turnOFFdevice();
                System.out.println(d + " is now OFF.");
            }
        } else {
            System.out.println("Device not found!");
        }

    }

    public static void adjustDevice(String d){
        Appliance device = devices.get(d);
        if (device == null) {
            System.out.println("Device not found!");
            return;
        }

        if (device.getStatus().equalsIgnoreCase("off")) {
            System.out.print(d + " is OFF. Do you want to turn it ON (y/n)? ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                device.turnONdevice();
                System.out.println(d + " is now ON.");
            } else {
                return;
            }
        }

        if (device instanceof Light) {
            System.out.print("Enter brightness level [1-10]: ");
            int brightness = sc.nextInt();
            sc.nextLine();  // Consume newline
            ((Light)device).setBrightness(brightness);
            System.out.println(d + " brightness set to " + brightness);
        } else if (device instanceof Fan) {
            System.out.print("Enter speed level [1-5]: ");
            int speed = sc.nextInt();
            sc.nextLine();  // Consume newline
            ((Fan)device).setSpeed(speed);
            System.out.println(d + " speed set to " + speed);
        }
    }

    public static void addNewDevice(String d) {
        if (!d.equalsIgnoreCase("Light") && !d.equalsIgnoreCase("Fan")) {
            System.out.println("Invalid device type.");
            return;
        }

        System.out.print("Enter device name: ");
        String name = sc.nextLine().trim();

        if (devices.containsKey(name.toLowerCase())) {
            System.out.println("The device cannot be added because it already exists in the system.");
            return;
        }

        if (d.equalsIgnoreCase("Light")) {
            devices.put(name.toLowerCase(), new Light(name));
        } else if (d.equalsIgnoreCase("Fan")) {
            devices.put(name.toLowerCase(), new Fan(name));
        }
    }

    public static void removeDevice(String d) {
        if (!devices.containsKey(d.toLowerCase())) {
            System.out.println("Sorry! This device does not exist in the system.");
            return;
        }
        Appliance removed = devices.remove(d.toLowerCase());
        System.out.println(removed.getName() + " has been removed from the system.");
    }

    public static void main(String[] args) {

        addDevices();

        System.out.println("===============================================");
        System.out.println("   Welcome to Smart Home Automation System!");
        System.out.println("===============================================");
        while (true){
            System.out.println("\nChoose an option:\n" +
                    "1. Show All Devices\n" +
                    "2. Turn ON Device\n" +
                    "3. Turn OFF Device\n" +
                    "4. Adjust Device\n" +
                    "5. Add a Device\n" +
                    "6. Remove a Device\n" +
                    "7. Exit\n" +
                    "Please select:");
            int selection = sc.nextInt();
            sc.nextLine();
            switch(selection) {
                case 1:
                    showDevices();
                    break;
                case 2:
                    if(devices.isEmpty()){
                        System.out.println("You do not have any devices");
                        break;
                    }
                    System.out.println("Which device do you want to turn ON:");
                    String selectedDevice = sc.nextLine().trim();
                    turnOn(selectedDevice);
                    break;
                case 3:
                    if(devices.isEmpty()){
                        System.out.println("You do not have any devices");
                        break;
                    }
                    System.out.println("Which device do you want to turn OFF:");
                    selectedDevice = sc.nextLine().trim();
                    turnOff(selectedDevice);
                    break;
                case 4:
                    if(devices.isEmpty()){
                        System.out.println("You do not have any devices");
                        break;
                    }
                    System.out.print("Which device do you want to adjust: ");
                    selectedDevice = sc.nextLine().trim();
                    adjustDevice(selectedDevice);
                    break;
                case 5:
                    System.out.print("Enter device type (Light/Fan): ");
                    String device = sc.nextLine().trim();
                    addNewDevice(device);
                    break;
                case 6:
                    System.out.print("Which device do you want to remove: ");
                    String name = sc.nextLine().trim();
                    removeDevice(name);
                    break;
                case 7:
                    System.out.println("Goodbye.");
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }

    }

}
