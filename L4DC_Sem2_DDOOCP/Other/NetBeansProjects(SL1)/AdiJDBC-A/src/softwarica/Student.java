/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwarica;

/**
 *
 * @author NCC
 */
public class Student {
    
    private int id;
    private String name;
    private String address;
    private ConnectionDB connection;
    
    public Student(){
        
        connection= new ConnectionDB();
    }
    
    public boolean addStudent(){
        String query="INSERT INTO student(name,address) VALUES('"+name+"','"+address+"')";
        return connection.iud(query);
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
