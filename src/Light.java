import java.util.Scanner;

public class Light extends Appliance{

    int brightness = 5;

    static String brightnessLevel(int brightness){

        if(brightness>=1 && brightness<=10){
            return "okk";
        }else{
           return "not okk";
        }

    }

}
