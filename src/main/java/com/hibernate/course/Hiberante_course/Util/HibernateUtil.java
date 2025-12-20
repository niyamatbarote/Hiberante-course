package com.hibernate.course.Hiberante_course.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


//import javax.security.auth.login.Configuration;   // This was giving error

// Singleton Design Pattern is Being Used
    // 1) Lazy Initialization :-
//    public class Samosa {
//
//        private static Samosa samosa;
//
//        // Constructor
//        private Samosa();
//
//        public static Samosa getSamosa(){
//
//            if (samosa == null){
//                samosa = new Samosa();
//            }
//            return samosa;
//        }
//    }
    // 2) Eager Initialization :-
//    public class Jalebi{
//        private static Jalebi jalebi = new Jalebi();
//
//        public static Jalebi getJalebi() {
//            return jalebi;
//        }
//    }
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
//        StandardServiceRegistry registry =
//                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//
//        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//
//        sessionFactory = metadata.getSessionFactoryBuilder().build();
        try {
//            StandardServiceRegistry registry =
//                    new StandardServiceRegistryBuilder()
//                            .configure() // auto-loads hibernate.cfg.xml from resources
//                            .build();
//
//            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//
//            sessionFactory = metadata.getSessionFactoryBuilder().build();

                sessionFactory = new Configuration()
                        .configure()    // autoconfigures "hibernate.cfg.xml"
                        .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
