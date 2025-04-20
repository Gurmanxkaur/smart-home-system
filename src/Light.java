public class Light extends Appliance {
    // property of light
    int brightness;  // stores brightness level between 1 to 10

    // constructor
    public Light(String name) {
        super(name);  // call parent constructor
        this.brightness = 5;  // default brightness
    }

    // sets brightness only if it is between the range
    public void setBrightness(int brightness) {
        if (brightness >= 1 && brightness <= 10) {
            this.brightness = brightness;
        }
    }

    // show device status with brightness if ON
    @Override
    public void showDeviceStatus() {
        super.showDeviceStatus();  // show name and status
        if (getStatus().equalsIgnoreCase("on")) {
            System.out.print("\n[");
            for (int i = 1; i <= 10; i++) {
                System.out.print(i <= brightness ? "+" : "-"); // shows brightness level in a bar
            }
            System.out.println("] " + brightness + "/10"); // shows number after bar
        } else {
            System.out.println();
        }
    }
}