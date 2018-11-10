/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Softwarica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pawan
 */
public class Student {
    
   private int id;
   private String first_name;
   private String last_name;
   private String address;
   private String age;
   private String phone_number;
   private String email;
   private final ConnectionDB conn;
   private final Validation valid=new Validation();
    
    public Student(){
        conn=new ConnectionDB();
    }

    
    public boolean addStudent(){
        String query="INSERT INTO `student_info`(`first_name`, `last_name`, `address`, `age`, `Phone Number`,`email`)"
                + " VALUES ('"+first_name+"','"+last_name+"','"+address+"','"+age+"','"+phone_number+"','"+email+"')";
        return conn.iud(query);
        
    }
    
    public boolean deleteStudent(String id){
        String query="delete from student where id= "+id+"";
        return conn.iud(query);
        
    }
    
    public boolean addStudent1(){
    String query1="INSERT INTO `student`(`First_name`,`Last_name`,`Address`,`Age`)VALUES('"+first_name+"','"+last_name+"','"+address+"','"+age+"')";    
        return conn.iud(query1);
    }
    
    
    public ArrayList<String[]> fetchAllStudents(){
      
         String query="select * from `student`";
           ResultSet result=conn.select(query);
           
           ArrayList<String []> data=new ArrayList<>();
        try {
          
          while(result.next()){
               String tmp[]={result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)};
               data.add(tmp);
           }
          return data;
       } catch (SQLException ex) {
           ex.printStackTrace();
           return data;
       }
    }
        
     public ArrayList<String[]> searchAllStudents(String term){
      
         String query="select * from `student` where First_name like '%"+term+"%'";
           ResultSet result=conn.select(query);
           
           ArrayList<String []> data=new ArrayList<>();
        try {
          
          while(result.next()){
               String tmp[]={result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)};
               data.add(tmp);
           }
          return data;
       } catch (SQLException ex) {
           ex.printStackTrace();
           return data;
       }
        
    }
        
        
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name)throws Exception {
       
     if(first_name==null || first_name.equals("")){
            throw new Exception("Name cannot be blank");
        }
     
      if(valid.isNameValid(first_name)){
      this.first_name = first_name;
      
      }else{
          throw new Exception("First name starts with capital letter");
      }
     
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name)throws Exception {
      if(last_name==null || last_name.equals("")){
           throw new Exception("Last name cannot be null");
       }
      if(valid.isLastNameValid(last_name)){  
       this.last_name = last_name;
       
      }else{
          throw new Exception("Last name starts with small letter");
      }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception{
      
    if(address==null || address.equals("")){
          throw new Exception("Address cannot be null");
       }
    this.address = address; 
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age)throws Exception {
       
        if(age==null || age.equals("")){
            throw new Exception("Age cannot be null");
        }
       
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) throws Exception {
        
       if(phone_number==null || phone_number.equals("")){
            throw new Exception("Phone number cannot be null");
        }
       if(valid.isPhoneNumberValid(phone_number)){
        this.phone_number = phone_number; 
        
       }else{
           throw new Exception("Invalid Phone number format.Please enter 10 digits");
       }
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email) throws Exception{
        
      if(email==null || email.equals("") ){
            throw new Exception("Email field is null");
        }
    if(valid.isEmailValid(email)){
        this.email=email;
        
    }else{
        throw new Exception("Email format is incorrect.Please try in this format somebody@gmail.com");
    }
        
    }

    
}
