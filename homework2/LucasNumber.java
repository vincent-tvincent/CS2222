import java.util.ArrayList;
public class LucasNumber {
    ArrayList<Float> runTime;
    float previousRunTime;
    float currentRunTime;
    public LucasNumber(){
        runTime = new ArrayList<>();
    }


    public static int getLucasNumber(int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 2;
        }else{
            return getLucasNumber(n-1) + getLucasNumber(n-2);
        }
    }

    public static int mySequence(int n){
        if(n == 0){
            return 12;
        }else if(n == 1){
            return 25;
        }else{
            return mySequence(n-1) * mySequence(n-2) + 365;
        }
    }
}
