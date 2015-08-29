package org.serginho.actions;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.serginho.dao.CompanyDAO;
import org.serginho.dao.EmployeeDAO;
import org.serginho.pojo.Company;
import org.serginho.pojo.Employee;

/**
 *
 * @author Sergio Sa Filho
 * @email code@serginho.org
 * @website www.Serginho.org
 * 
 */
@ManagedBean(name="EmployeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {
    private Employee employee = new Employee();

    public EmployeeBean(){
        defaultValues();
    }
    
    public void defaultValues(){
        this.employee = new Employee();
    }
    
    public String addEmployee(){
        if(new EmployeeDAO().save(this.employee) != null){
            FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee", "Successfully Added."));

            defaultValues();

            return "";
        }
        
        return ""; // You can create a specif error.xhtml page and handle here.
    }

    public String updateEmployee(){
        if(new EmployeeDAO().update(this.employee)){
            FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee", "Successfully Updated."));

            defaultValues();

            return "";
        }
        
        return ""; // You can create a specif error.xhtml page and handle here.
    }
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public List<Company> getCompanies(){
        return new CompanyDAO().getCompanies();
    }
    
    public List<Employee> getEmployees(){
        return new EmployeeDAO().getEmployees();
    }
}
