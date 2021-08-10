// A java program to demonstrate uses of
// static keyword with methods, variables,
// static blocks
  
// Student class
public class Student 
{
    // Object variable/Model variable
    int rollNumber;
    String name;
    float marks = 0.0f;
      
    // static variable/ Class variable
    static String schoolName;

    // static variable/ Class variable
    static String favSubject = "Math";
      
    // static counter
    static int counter = 0;
    
    // 1st static block
    static{
        System.out.println("1st Static Block, counter - " + counter);
        counter = counter + 500;
        System.out.println("Static Block 1, After adding 500, counter - " + counter);
    }
    
    //2nd static block
    static{
        System.out.println("2nd Static Block, counter - " + counter);
        counter = counter + 300 ;
        System.out.println("Static Block 2, After adding 300, counter - " + counter);
    }
   
    // Constructor with parameters
    public Student(String name) 
    {
        System.out.println("Constructor is called");
        this.name = name;
        System.out.println("In Constructor, Name is set");
        this.rollNumber = setRollNumber();
        this.marks = this.rollNumber*10;
        System.out.println("In Constructor, rollNumber is set");
    }

       
    // Constructor with NO parameters
    // We don't need this constructor. But in default, it is created by compiler in .
    public Student() 
    {

    }

    // static method
    static int setRollNumber()
    {
        System.out.println("Static Method setRollNo(), counter - " + counter);
        counter++;
        System.out.println("Static Method setRollNo(), After adding 1, counter - " + counter);
        return counter;
    }
      
    // static method
    static void setSchoolName(String name){
        System.out.println("Static Method setSchoolName(), schoolName - " + schoolName);
        schoolName = name ;
        System.out.println("Static Method setSchoolName(), After assigning name, schoolName - " + schoolName);
    }
      
    // instance method
    void getStudentInfo(){
        System.out.println("Student Name - " + this.name);
        System.out.println("Student RollNumber - " + this.rollNumber);
        System.out.println("Student Marks - " + this.marks);
          
        // accessing static variable
        System.out.println("Accessing Static Variable School RollNumber - " + rollNumber);
    }

    public static void main(String[] args)
    {
        // For calling a static method
        // we don't need to instantiate Student class
        System.out.println("Setting student schoolName & Creating 2 student object");
        //printing static variable without calling the Class name
        System.out.println(favSubject);
        Student.setSchoolName("DRMC");
        Student s1 = new Student("Asif");
        Student s2 = new Student("Sakibul");
        System.out.println("After creating 2 student object");
          
        s1.getStudentInfo();
        System.out.println("After creating 2 student object, Student 1 info is called");
        System.out.println("s1.schoolName " + s1.schoolName );
        s1.setSchoolName("Always DRMC############################");
        System.out.println("s2.schoolName " + s2.schoolName );
        s2.getStudentInfo();
        System.out.println("After creating 2 student object, Student 2 info is called");
          
    }
}



/*******************OUTPUT******************** */

// 1st Static Block, counter - 0
// Static Block 1, After adding 500, counter - 500
// 2nd Static Block, counter - 500
// Static Block 2, After adding 300, counter - 800
// Setting student schoolName & Creating 2 student object
// Math
// Static Method setSchoolName(), schoolName - null
// Static Method setSchoolName(), After assigning name, schoolName - DRMC
// Constructor is called
// In Constructor, Name is set
// Static Method setRollNo(), counter - 800
// Static Method setRollNo(), After adding 1, counter - 801
// In Constructor, rollNumber is set
// Constructor is called
// In Constructor, Name is set
// Static Method setRollNo(), counter - 801
// Static Method setRollNo(), After adding 1, counter - 802
// In Constructor, rollNumber is set
// After creating 2 student object
// Student Name - Asif
// Student RollNumber - 801
// Student Marks - 8010.0
// Accessing Static Variable School RollNumber - 801
// After creating 2 student object, Student 1 info is called
// s1.schoolName DRMC
// Static Method setSchoolName(), schoolName - DRMC
// Static Method setSchoolName(), After assigning name, schoolName - Always DRMC############################
// s2.schoolName Always DRMC############################
// Student Name - Sakibul
// Student RollNumber - 802
// Student Marks - 8020.0
// Accessing Static Variable School RollNumber - 802
// After creating 2 student object, Student 2 info is called
