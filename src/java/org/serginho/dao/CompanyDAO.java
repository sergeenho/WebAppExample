package org.serginho.dao;

import java.util.List;
import org.serginho.pojo.Company;

/**
 *
 * @author Sergio Sa Filho
 * @email code@serginho.org
 * @website www.Serginho.org
 * 
 */
public class CompanyDAO extends GenericDAO{
    private final GenericDAO<Company> genericDAO;
    
    public CompanyDAO(){
        this.genericDAO = new GenericDAO(){};
    }
    
    public List<Company> getCompanies(){
        return this.genericDAO.findList("FROM org.serginho.pojo.Company");
    }
    
    public Company getCompany(int id){
        return this.genericDAO.find("FROM org.serginho.pojo.Company WHERE id = " + id);
    }
}
