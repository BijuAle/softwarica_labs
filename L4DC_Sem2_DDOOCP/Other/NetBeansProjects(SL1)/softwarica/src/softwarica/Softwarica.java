

package softwarica;
public class Student {
    String name;
    int roll_no;
    int marks;
    void getmarks(int m)
    {
        marks=m;
    }
    void getname(String s,int roll)
    {
        name=s;
        roll_no=roll;     
    }
    void report()
    {
        System.out.println("student name:"+name);
        System.out.println("roll no :"+roll_no);
        System.out.println("marks:"+marks);
    }
}



