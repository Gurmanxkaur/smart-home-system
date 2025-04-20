public class Appliance implements SmartDevice {
    // instance variables
    String name;
    String status;  // stores if the device is on or off

    // constructor
    public Appliance(String name) {
        this.name = name;
        this.status = "off";  // when created, default status is OFF
    }

    // turn ON the device
    @Override
    public void turnONdevice() {
        this.status = "on"; // when called, device is on
    }

    // turn OFF the device
    @Override
    public void turnOFFdevice() {
        this.status = "off"; // when called, device is off
    }

    // shows device name and its status
    @Override
    public void showDeviceStatus() {
        System.out.print(name + ": " + status.toUpperCase());
    }

    // getter method
    public String getStatus() {
        return status; // returns the status
    }

    // getter method
    public String getName() {
        return name; // returns the name
    }
}