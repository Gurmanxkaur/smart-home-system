public class Fan extends Appliance {

    int speed = 1;

    static String speedLevel(int speed){

        if(speed>=1 && speed<=5){
            return "okk";
        }else{
            return "not okk";


        }

    }

}
