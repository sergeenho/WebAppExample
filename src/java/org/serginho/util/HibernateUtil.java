package org.serginho.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sergio Sa Filho
 * @email code@serginho.org
 * @website www.Serginho.org
 * 
 */
public class HibernateUtil {
    private static SessionFactory instance = null;
    
    public static SessionFactory getSessionFactory(){
        if(instance == null)
            createInstance();
        
        return instance;
    }
    
    private synchronized static void createInstance(){
        if(instance != null)
            return;
        
        instance = new Configuration().configure().buildSessionFactory();
    }
}
