public class Fan extends Appliance {
    // property of fan
    int speed;  // stores speed level between 1 to 5

    // constructor
    public Fan(String name) {
        super(name);  // call parent constructor
        this.speed = 1;  // default speed
    }

    // sets speed only if it is between the range
    public void setSpeed(int speed) {
        if (speed >= 1 && speed <= 5) {
            this.speed = speed;
        }
    }

    // show device status with speed if ON
    @Override
    public void showDeviceStatus() {
        super.showDeviceStatus();  // show name and status
        if (getStatus().equalsIgnoreCase("on")) {
            System.out.print("\n[");
            for (int i = 1; i <= 5; i++) {
                System.out.print(i <= speed ? "+" : "-"); // shows speed level in a bar
            }
            System.out.println("] " + speed + "/5"); // shows number after bar
        } else {
            System.out.println();
        }
    }
}