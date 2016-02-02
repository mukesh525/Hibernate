/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mukesh.hibernate.entity;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mukesh
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    private static  StandardServiceRegistry serviceRegistry;
    
    
    public static SessionFactory createSessionFactory(){
        Configuration configuration=new Configuration();
        configuration.configure();
        serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
     }
    
}
