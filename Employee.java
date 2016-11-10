import java.util.Random;
/**
 * Created by Chris on 11/1/2016.yo this is a test
 *
 */
public class Employee {

    private int aht;
    private double percentAvail;
    private int totalChats;
    private String name;
    private static int goal = 550;
    private static double percentGoal = .80;
    private double inGoal;

    public Employee(String name){

            Random rand = new Random();
            double min = .4;
            double max = 1;

        this.aht = (int)(rand.nextGaussian()*200 +800);
        this.percentAvail = ((min + (max - min) * rand.nextDouble()));
    }
    public static int checkSD(Employee[] emp){
        int count = 0;
        for(Employee e:emp){
            if(e.getAht()>=600&&e.getAht()<=1000) count++;
        }
        return count;
    }

    public Employee(int aht, double percentAvail, int totalChats, String name) {
        this.aht = aht;
        this.percentAvail = percentAvail;
        this.totalChats = totalChats;
        this.name = name;
    }

    public double getAht() {
        return aht;
    }

    public void setAht(int aht) {
        this.aht = aht;
    }

    public double getPercentAvail() {
        return percentAvail;
    }

    public void setPercentAvail(double percentAvail) {
        this.percentAvail = percentAvail;
    }

    public int getTotalChats() {
        return totalChats;
    }

    public void setTotalChats(int totalChats) {
        this.totalChats = totalChats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
