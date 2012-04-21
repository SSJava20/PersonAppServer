///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.softserve.persondao;
//
//import org.hibernate.HibernateException;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//
///**
// *
// * @author Nubaseg
// */
//public class HibernateUtil {
//
////    private volatile static HibernateUtil instance;
////
////    private HibernateUtil() {
////    }
////
////    public static HibernateUtil getInstance() {
////        if (instance == null) {
////            synchronized (HibernateUtil.class) {
////                if (instance == null) {
////                    instance = new HibernateUtil();
////                }
////            }
////        }
////        return instance;
////    }
////
//    public static SessionFactory configureSessionFactory() throws HibernateException {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        return sessionFactory;
//    }
//}
