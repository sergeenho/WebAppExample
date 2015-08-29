package org.serginho.pojo;
// Generated Aug 28, 2015 6:39:58 PM by Hibernate Tools 4.3.1



/**
 * Employee generated by hbm2java
 */
public class Employee  implements java.io.Serializable {


     private int id;
     private Company company;
     private String name;
     private String phone;
     private String email;

    public Employee() {
        this.company = new Company();
    }

	
    public Employee(int id) {
        this.id = id;
    }
    public Employee(int id, Company company, String name, String phone, String email) {
       this.id = id;
       this.company = company;
       this.name = name;
       this.phone = phone;
       this.email = email;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}


