package com.example.a20190515_imageapipost;


public class Employee {
    String id, employee_name, profile_image;
    float employee_salary;
    int employee_age;

    public Employee(String id, String employee_name, String profile_image, float employee_salary, int employee_age) {
        this.id = id;
        this.employee_name = employee_name;
        this.profile_image = profile_image;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public float getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(float employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    @Override
    public String toString() {
        return "{" +
                "id:'" + id + '\'' +
                ", employee_name:'" + employee_name + '\'' +
                ", profile_image:'" + profile_image + '\'' +
                ", employee_salary:" + employee_salary +
                ", employee_age:" + employee_age +
                '}';
    }

}
