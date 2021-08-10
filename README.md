@author - Ahmed Tareque - 10th August,2021
# Uses of Static Keyword as static blocks, static variables/fields, static methods, and static classes

### First thing first, 
1. static means it `belongs to the class not the object`. So, while instantiating an object of that class, static variables is not going to be created while other non-static variables will be created. So, while calling any static variables or methods we just need to call `className.staticMethod()  or className.staticVariable`.
2. If there is `one or multiple static blocks` in the class It will be `called before constructor` one by one in the order they are defined.
3. Static block `doesn't accept non-static variables`.
4. Static method `doesn't accept non-static variables`.
5. But if we really need to use a non-static variables in static method we need to `create an object` to access it.
6. `this` and `super` cannot be used in a static method.
7. `non-static method/Default methods can access static method and static variables`.
8. Static block is executed when a `class is first loaded into the JVM`.

## Static Blocks & Static Methods & Static Variables
````java
public class Student 
{
    // Object variable/Model variable
    String name;
    static int marks = 10;
    
    // 1st static block
    static{
        System.out.println("1st Static method is executed");
    }
    // 2nd static block
    static{
        System.out.println("2nd Static method is executed");
    }
    // Constructor with parameters
    public Student(String name) {
        this.name = name;
    }
    //static method
    public static void getStaticStudentInfo(){
    //accessing another static method
    int p = getStaticStudentInfo2();
    Student a = new Student("Sakibul");
    //accessing non-static variable
    System.out.println("Static Student Name - " + a.name + ". His marks is "+ p);
    //accessing non-static method
    a.getStudentInfo();
    }
    //static method
    public static int getStaticStudentInfo2(){
        //accesing static variable
        return (marks*10);
    }
    // instance method
    void getStudentInfo() {
        //accessing static method
        int a = getStaticStudentInfo2();
        //accessing static variables
        System.out.println("Base marks is "+ marks + ". Student Name - " + this.name + ". His marks is " + a);
    }
    public static void main(String[] args)
    {
        // For calling a static method
        // we don't need to instantiate Student class 
        Student.getStaticStudentInfo();
        Student s1 = new Student("Asif");
        Student.getStaticStudentInfo();
        s1.getStudentInfo();
    }
}
````
### The output is:
````
1st Static method is executed
2nd Static method is executed
Static Student Name - Sakibul. His marks is 100
Base marks is 10. Student Name - Sakibul. His marks is 100 
Static Student Name - Sakibul. His marks is 100
Base marks is 10. Student Name - Sakibul. His marks is 100 
Base marks is 10. Student Name - Asif. His marks is 100 
````

## Static Class & Nested static class



````java
public class Test 
{
    static int marks = 10;
    int n = 5;
    public static class aNestedStaticClass{
        public void printMessage()
        {
            //trying to access non static variable
            //So making an object to access it
            Test x = new Test();
            System.out.println(
                "Showing marks from Nested Static Class"
                + marks + x.n);
        }
    }
    
        
    public class aNestedNonStaticClass{
        public void printMessage()
        {
            // accessing static variable from non-static method
            System.out.println(
                "Showing marks from Nested Non Static Class"
                + marks+ n*5);
        }
    }

    public static void main(String[] args)
    {
        //accessing nested static class
        Test.aNestedStaticClass obj = new Test.aNestedStaticClass();
        obj.printMessage();
        //accessing nested non-static class
        Test.aNestedNonStaticClass anotherObj = new Test().new aNestedNonStaticClass();
        anotherObj.printMessage();
    }
}
````
### The output is:
````
Showing marks from Nested Static Class 105
Showing marks from Nested Non Static Class 1025
````