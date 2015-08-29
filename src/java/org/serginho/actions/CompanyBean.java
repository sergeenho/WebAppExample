/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.serginho.actions;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.serginho.dao.CompanyDAO;
import org.serginho.pojo.Company;

/**
 *
 * @author Sergio Sa Filho
 * @email code@serginho.org
 * @website www.Serginho.org
 * 
 */
@ManagedBean(name="CompanyBean")
@SessionScoped
public class CompanyBean implements Serializable {
    private Company company = new Company();

    public CompanyBean(){
        defaultValues();
    }
    
    public void defaultValues(){
        this.company = new Company();
    }
    
    public String addCompany(){        
        if(new CompanyDAO().save(this.company) != null){
            FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Company", "Successfully Added."));

            defaultValues();

            return "";
        }
        
        return ""; // You can create a specif error.xhtml page and handle here.
    }

    public String updateCompany(){
        if(new CompanyDAO().update(this.company)){
            FacesContext context = FacesContext.getCurrentInstance();            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Company", "Successfully Updated."));

            defaultValues();

            return "";
        }
        
        return ""; // You can create a specif error.xhtml page and handle here.
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    public List<Company> getCompanies(){
        return new CompanyDAO().getCompanies();
    }
}
