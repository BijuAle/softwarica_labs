/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author Biju Ale
 */
public class StudentDetail extends PhysicalInfo {

    String Name, Batch;
    int RollNo;

    void setStudentDetail(String Name, String Batch, int RollNo) {
        this.Name = Name;
        this.Batch = Batch;
        this.RollNo = RollNo;

    }

    void display() {
        System.out.println("Name: " + this.Name);
        System.out.println("Batch: " + this.Batch);
        System.out.println("RollNo: " + this.RollNo);

        System.out.println("Height: " + super.height);
        System.out.println("Weight: " + super.weight);
        
        System.out.println("Marks: " + super.subjects);
        

    }
}
