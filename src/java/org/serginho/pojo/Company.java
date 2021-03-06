package org.serginho.pojo;
// Generated Sep 30, 2015 10:09:54 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name="company",schema="public")
public class Company  implements java.io.Serializable {
    private int id;
    private String name;
    private Set<Employee> employees = new HashSet<Employee>(0);

    public Company() {
    }

    public Company(String name, Set<Employee> employees) {
       this.name = name;
       this.employees = employees;
    }
   
     @SequenceGenerator(name="generator", sequenceName="company_id_seq")@Id @GeneratedValue(strategy=SEQUENCE, generator="generator")

    
    @Column(name="id", nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy="company")
    public Set<Employee> getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}


