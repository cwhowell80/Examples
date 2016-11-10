/**
 * Related topics described by this file of classes
 * Inheritance/Encapsulation/
 * Showing inherited variables though a hierarchy of multiple classes
 * Which one is used when a parent class extends another class both having the same variable
 * How to use casting to access specific variables of a Grandparent/Parent class
 * How visibility modifiers can restrict what is inherited by a subclass
 *Calling of Instance and Static methods using a specific object type with various reference types
 * How does this relate to constructors being called as well as the order in which they are called
 * How does this effect which method will be called when overriding parent class methods
 * How does this effect calling methods that are not overridden but unique to a certain class
 * How does this relate to declarations of throwing specific exceptions
 * How does inheritance work with the type of exceptions being thrown relative to a class hierarchy
 * (not yet implemented) How must declarations of exceptions being thrown be defined in constructors within a hierarchy?*/
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {

/*******************************************************************************************************
 //This section of code is to illustrate the process of calling multiple constructors
 that are directly related through Inheritance. Likewise show what happens in the background
 for each specific case relative to the order in which they are called
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
        int x = 0, y = 0;
        int answer = 0, answer2 = 0;
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
        //     try/catch/finally used for handeling exceptions
        try {
            // gp has a reference of the Grandparent class but points to a object of the Child class
            System.out.println("Next line in main is: answer = gp.divide(x, y); ");
            answer = gp.divide(x, y);// these are allowed unlike tryme because they are methods that exist in
            //GrandParent but have been overridden by the child class
            // divide method is non-static and thus an instance method
        } catch (Exception e) {//This works because Exception is the Grandparent of the other two exception types
            //and thus cast a wide enough net to catch them all
            System.out.println("You have done something bad...");
        } finally {  //finally gets called reguardless if exception is called or not
            // try/catch block must have a catch or finally block and can have both
            System.out.println("finally");
        }
        try {
            //divide2 method is static
            System.out.println("Next line in main is: answer = gp.divide2(x, y); ");
            answer2 = gp.divide2(x, y);
        } catch (Exception e) {//This works because Exception is the Grandparent of the other two exception types
            // and thus cast a wide enough net to catch them all erguardless of which method is
            // called from the 3 classes
            System.out.println("You have done something bad, i mean real bad...");
        }
        //The following is allowed because the child class inherits grandparents gpvar even though it is not implemented
        //in the child class
        System.out.println("cd calling gp var " + cd.gpVar);
        //This illustrates that it will use Parent value for combo, being the next in line in the hiarchy
        System.out.println("accessing combo using child reference " + cd.combo1);
        //This next line is commented out because it will not compile with it uncommented
        // You can not access the combo2 var because it is set to private and it shadows the parent var combo2
        //and thus hides it. A subclass does not inherit private variables or methods
        //System.out.println("Trying to access combo2 using Child class reference"+ cd.combo2);
        //This next line does a cast changing the reference from the Child type to Grandparent type
        //This thus ignores the Parent combo2 shadowing the grandparent combo2
        System.out.println("Using Child refrence and casting Grandparent to access combo2 " + ((GrandParent) cd).combo2);
        System.out.println();
        System.out.println("Your answer is " + answer);
        //The info determined are determined by refernce type and not object type
        // thus gp.x will give the info stored in grandparent class instead of child class even though
        // the atual object is of a Child Class. It was defined by GrandParent gp = new Child()
        System.out.println("gp x is " + gp.x + " gp y is " + gp.y);
        // cd is a reference of type Child so it will print info stored in Child Class
        System.out.println("cd x is " + cd.x + " cd y is " + cd.y);
        //These next two lines show two subtle features of system.out.println as well as how strings are defined and
        //stored. The system.out.println invokes a toString method in the background
        //likewise because the string class overrides The Objects class toString() method and these methods are not static
        //then the String class method is used. THe Object class to string would result in
        //getClass().getName() + '@' + Integer.toHexString(hashCode()
        Object s = new String("I am a string");
        System.out.println(s);
        method(gp);
        System.out.println("gp x is " + gp.x + " gp y is " + gp.y);
        System.out.println("gp x is " + ((Parent)gp).x + " gp y is " + gp.y);
        GrandParent gp2 = new GrandParent();

        /*This next section is commented out so that a runtime error will not occur. Since gp2 is a reference of type
        GrandParent and points to a Grandparent object only the grandparent class has been initiated...The GrandParent has
        no Parent of child class associated with it. Thus trying to cast grandparent to parent will fail. The program will
        compile and run fine until it gets to invoking that method and will have a critical error and shut down due to a
        CLassCastException... One could handle this exception by indicating in the throws clause of the method and use
        a try catch block where the method is invoked
         */

        //method(gp2);
        System.out.println("gp2 x is " + gp2.x + " gp y is " + gp.y);
        //System.out.println("gp2 parent x is " + ((Parent)gp2).x + " gp y is " + gp.y);

    }


    public static void method(GrandParent gp) {
        //This Method shows that objects are indeed passed by value although slightly confusing
        //The gp here is a local value that is an address to the same object as the reference that was put in the parameters
        // when invoking the method. It is thus a copy of the remote control to that object
        //Thus you can make changes to the object and it will acctually change the object
        //however if you set gp = null it does not nullify the object but instead changes what this local reference points to.
        gp.x = 24;
        ((Parent) gp).x = 34;
        ((Child) gp).x = 44;
        gp=null;
    }

}
//A class that represents the object of a GrandParent
class GrandParent{
    GrandParent(){
        //Just a notification to show the constructor is being called
        System.out.println(" Calling GrandParent Constructor");
    }
    GrandParent(int x){
        this.x = x;
        //notice that constructor will never be used to initiate an instance of one of the subclasses since they
        // do not explicitly call it with super(int x).. The compiler automatically assumes a no arg constructor and calls
        //super() in all the subclasses as the first line.. Since this constructor has been created the no arg constructor above
        //must be made by programer so that when the compiler assumes a no arg constructor there will be one to call
        // You could also specify in the sub class the constructor you wanted to call, that has been created in the parent
        //class and thus there is no need for compiler to call super()..
        //THus If you comment out the no arg constructor above this file will not compile
    }
    int x = 4;
    static  int y = 4;
    String gpVar = "gpVar";
    String combo1 = "gpCombo1";
    String combo2 = "gpCombo2";
   //Constructor for the GrandParent Class
    //Notice that no public visibility modifier is used
    // If no visibility modifier is used then the default visibility is given
    // which gives access to all classes within the same package


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
    String parentVar = "pVar";
    String combo1 = "Parent combo1";
    private String combo2 = "private Parent combo";// Encapsulation
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
        super();//not acctually needed because if you dont define which constructor of parent class to use it will
        // call the no args constructor automatically super()
        //If you hava a constructor with args then a default no args constructor wont be made and the automatic call
        //will not work and thus the program will not compile unless you specify a call to constructor with correct args..
        //The point is for an instance of a subclass to be created at least one constructor of all its parent classes must be called
        // and initiated as well.. This is just automatically done when only no arg constructors are used...
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