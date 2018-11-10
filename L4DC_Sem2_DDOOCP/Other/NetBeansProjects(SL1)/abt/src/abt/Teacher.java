
package abt;

public class Teacher extends Person{
    float salary;
    void DisplayPerson()
    {
        System.out.println("My name is " + super.name);
        System.out.println("my age is" + super.age);
        System.out.println("my address is " + super.address);
        System.out.println("my salary is" + this.salary);
        
    }
    public static void main(String[] args) {
        Teacher obj = new Teacher();
        obj.name = "Kiran";
        obj.age=22;
        obj.address="ktm";
        obj.salary = 300000;
        obj.DisplayPerson();
    }
    
}
