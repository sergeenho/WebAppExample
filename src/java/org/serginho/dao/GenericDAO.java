package org.serginho.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.serginho.util.HibernateUtil;

/**
 *
 * @author Sergio Sa Filho
 * @email code@serginho.org
 * @website www.Serginho.org
 * @param <T>
 * 
 */
public abstract class GenericDAO<T> {
    private final Session session;
    
    public GenericDAO(){
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public T find(String query){
        T result = null;
        Transaction tx = null;
                
        try{
            tx = this.session.beginTransaction();        
            Query q = this.session.createQuery(query);

            if(!q.list().isEmpty())
                result = (T) q.list().get(0);
            tx.commit();
        }catch(HibernateException ex){
            if (tx!=null) tx.rollback();
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.session.close();
        }
        
        return result;
    }
    
    @Transactional
    public List<T> findList(String query){
        List<T> result = null;
        Transaction tx = null;
        
        try{
            tx = this.session.beginTransaction();
            Query q = this.session.createQuery(query);
            if(!q.list().isEmpty())
                result = (List<T>) q.list();
            tx.commit();
        }catch(HibernateException ex){
            if (tx!=null) tx.rollback();
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.session.close();
        }
        
        return result;
    }
    
    public T save(T item){
        Transaction tx = null;
        
        try{
            tx = this.session.beginTransaction();
            this.session.save(item);
            tx.commit();
        }catch(HibernateException ex){
            if (tx!=null) tx.rollback();
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            this.session.close();
        }
        
        return item;
    }
    
    public boolean update(T item){
        Transaction tx = null;
        
        try{
            tx = this.session.beginTransaction();
            this.session.update(item);
            tx.commit();
        }catch(HibernateException ex){
            if (tx!=null) tx.rollback();
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            this.session.close();
        }
        
        return true;
    }
}
