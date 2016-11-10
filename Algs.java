/**
 * Created by Chris on 11/1/2016.
 */
public class Algs {

    public static void main(String[] args) {
        Employee emp1 = new Employee("Josh");
        Employee[] group = new Employee[25];


        for(int i=0; i<group.length; i++){
           group[i] = new Employee(Integer.toString(i));
        }

        for(Employee emp: group){
            System.out.println(emp.getAht());
        }
        System.out.println("total number of points within 1 standerd deviation is " + Employee.checkSD(group));

    }

}
