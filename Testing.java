/**
 * Related topics described by this class
 *Calling of Instance and Static methods using a specific object type with various reference types
 * How does this relate to constructors being called as well as the order in which they are called
 * How does this effect which method will be called when overriding parent class methods
 * How does this effect calling methods that are not overriden but unique to a certain class
 * How does this relate to declarations of throwing specific exceptions
 * How does inheritance work with the type of exceptions being thrown relative to a class hierchy
 * (not yet implemented) How must declarations of exceptions being thrown be defined in constuctors within a hiearchy?*/
import java.util.Scanner;

public class Testing {
    public static void main(String[] args){

/*******************************************************************************************************
        //This section of code is to illustrate the process of calling multiple constructors
            that are directly related through Inheritance. Likewise show what happens in the background
            for each specific case
 ***************************************************************************************/
        System.out.println("Next line in main, GrandParent gp = new Child()");
        GrandParent gp = new Child();
        System.out.println();

        System.out.println("Next line in main, Child cd = new Child()");
        Child cd = new Child();
        System.out.println();

        System.out.println("Next line in main, Parent parent = new Parent();");
        Parent parent = new Parent();
        System.out.println();

        System.out.println("Next line in main, GrandParent grandParent = new GrandParent();");
        GrandParent grandParent = new GrandParent();
        System.out.println();
/*******************************************************************************************************/
        Scanner input = new Scanner(System.in);
        int x =0,y=0;
        int answer = 0,answer2 =0;
        System.out.println("give me and int ");
        x = input.nextInt();
        System.out.println("give me and int ");
        y = input.nextInt();
        /**************************************************************************************************/
        // gp has a reference of the Grandparent class but points to a object of the Child class
        //Neither works because grandparent does not have this method
        //Even though child method does...Only works when using overriding methods
        // remove the // before method call to see the error

        //gp.tryme1();
        //gp.tryme2();

        /**************************************************************************************************/
        //These next two work because cd is a reference of type Child pointing to an object of CHild class
        //where tryme1 and tryme2 are defined
        cd.tryme1();
        cd.tryme2();
        System.out.println();

        try {
            // gp has a reference of the Grandparent class but points to a object of the Child class
            System.out.println("Next line in main is: answer = gp.divide(x, y); ");
            answer = gp.divide(x, y);// these are allowed unlike tryme because they are methods that exist in
                                    //GrandParent but have been overridden by the child class
            // divide method is non-static and thus an instance method
        }
        catch(Exception e){//This works because Exception is the Grandparent of the other two exception types
                           //and thus cast a wide enough net to catch them all
            System.out.println("You have done something bad...");
        }
        finally{  //finally gets called reguardless if exception is called or not
                  // try/catch block must have a catch or finally block and can have both
            System.out.println("finally");
        }
        try {
           //divide2 method is static
            System.out.println("Next line in main is: answer = gp.divide2(x, y); ");
            answer2 = gp.divide2(x, y);
        }
        catch(Exception e){//This works because Exception is the Grandparent of the other two exception types
            // and thus cast a wide enough net to catch them all erguardless of which method is
            // called from the 3 classes
            System.out.println("You have done something bad, i mean real bad...");
        }

        System.out.println();
        System.out.println("Your answer is "+ answer);
        System.out.println("gp x is "+gp.x +" gp y is "+gp.y);
        System.out.println("cd x is "+cd.x +" cd y is "+cd.y);

    }

}


//A class that represents the object of a GrandParent
class GrandParent{
    int x = 4;
    static  int y = 4;

   //Constructor for the GrandParent Class
    //Notice that no public visibility modifier is used
    // If no visibility modifier is used then the default visibility is given
    // which gives access to all classes within the same package
    GrandParent(){
        //Just a notification to show the constructor is being called
        System.out.println(" Calling GrandParent Constructor");
    }

    int divide(int x, int y)throws Exception
    {
        System.out.println(" Grandparent divide(int x, int y) is being called");
        return x/y;

    }
    static int divide2(int x, int y)throws Exception
    {
        System.out.println(" GrandParent --static int divide2(int x, int y)--- is being called");
        return x/y;

    }

}
// A class representing the object of Parent
class Parent extends GrandParent{
    int x = 1;
    static  int y = 1;

    //Constructor for the Parent class
    Parent(){
        System.out.println(" Calling Parent Constructor");
    }

    int divide(int x, int y)throws RuntimeException
    {
        System.out.println(" parent divide(int x, int y) is being called");
        return x/y;

    }
    static int divide2(int x, int y)throws RuntimeException
    {
        System.out.println(" parent --static int divide2(int x, int y)-- is being called");
        return x/y;

    }

}
class Child extends Parent{
    int x = 2;
    static  int y = 2;
    //Scanner input = new Scanner(System.in);

    // Constructor for the Child Class
    Child(){
        System.out.println(" Calling Child Constructor");
    }

    int divide(int x, int y)throws ArithmeticException
    {
        System.out.println(" child divide is being called");
        return x/y;

    }
    static int divide2(int x, int y)throws ArithmeticException
    {
        System.out.println(" child divide2 is being called");
        return x/y;

    }
    static void tryme1(){
        System.out.println(" static Tryme1 of the child class");
    }
     void tryme2(){
        System.out.println(" instance Tryme2 of the child class");
    }


}