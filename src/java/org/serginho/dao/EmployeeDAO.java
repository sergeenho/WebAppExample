package org.serginho.dao;

import java.util.List;
import org.serginho.pojo.Employee;

/**
 *
 * @author Sergio Sa Filho
 * @email code@serginho.org
 * @website www.Serginho.org
 * 
 */
public class EmployeeDAO {
    private final GenericDAO<Employee> genericDAO;
    
    public EmployeeDAO(){
        this.genericDAO = new GenericDAO(){};
    }
    
    public Employee save(Employee employee){
        return this.genericDAO.save(employee);
    }
    
    public boolean update(Employee employee){
        return this.genericDAO.update(employee);
    }
    
    public Employee getEmployee(int id){
        return this.genericDAO.find("FROM org.serginho.pojo.Employee WHERE id = " + id);
    }
    
    public List<Employee> getEmployees(){
        return this.genericDAO.findList("FROM org.serginho.pojo.Employee ORDER BY name");
    }
}
