import java.util.*;

public class Appliance implements SmartDevice{
    static Scanner sc=new Scanner(System.in);

    static HashMap<String, String> devices = new HashMap<>();
    static String name;
    static String status="off";

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        Appliance.status = status;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Appliance.name = name;
    }

    public static void addDevices(){
        devices.put("Light",getStatus());
        devices.put("Fan",getStatus());
    }

    public static void showDevices(){

        System.out.println("*** Showing All Devices ***");
        devices.forEach((key, value) -> {
            System.out.println(key + ": " + value.toUpperCase());
        });

    }

    public static void turnOn(String d){

        devices.forEach((key, value) -> {
            if(Objects.equals(d, key)){
                System.out.println();
                setStatus("ON");
            }
            System.out.println(key + ": " + value.toUpperCase());
        });

    }

    public static void turnOff(){

    }

    public static void adjustDevice(){

    }

    @Override
    public  void turnONdevice() {

    }

    @Override
    public void turnOFFdevice() {

    }

    @Override
    public void showDeviceStatus() {

    }

    public static void main(String[] args) {

        addDevices();

        System.out.println("===============================================");
        System.out.println("   Welcome to Smart Home Automation System!");
        System.out.println("===============================================");
        while (true){
            System.out.println("Choose an option:\n" +
                    "1. Show All Devices\n" +
                    "2. Turn ON Device\n" +
                    "3. Turn OFF Device\n" +
                    "4. Adjust Device\n" +
                    "5. Exit\n" +
                    "Please select:");
            int selection = sc.nextInt();
            switch(selection) {
                case 1:
                    showDevices();
                    break;
                case 2:
                    System.out.println("Which device do you want to turn ON:");
                    String selectedDevice = sc.next();
                    turnOn(selectedDevice);
                    break;
                case 3:
                    turnOff();
                    break;
                case 4:
                    adjustDevice();
                    break;
                case 5:
                    System.out.println("Goodbye.");
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }

    }
}
