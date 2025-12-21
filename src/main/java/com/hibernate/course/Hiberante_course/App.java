package com.hibernate.course.Hiberante_course;

import com.hibernate.course.Hiberante_course.Util.HibernateUtil;
import com.hibernate.course.Hiberante_course.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        System.out.println( "Hello World!" );
        System.out.println( "We are Going to learn Hibernate..! " );

        // create Student
        // SAVE : hibernate

        // Create student Object:-
        Student student1 = new Student();

        student1.setName("Niyamat");
        student1.setRollNum(1);
        student1.setCollege("Alard College of Engg");
        student1.setStandard("TE");
        student1.setScore(9.0);
        student1.setAbout("He is a Bright Student");



        // SessionFactory is a LONG-LIVED OBJECT
        SessionFactory sessionFactory = HibernateUtil.getsessionFactory(); // Session Creation
//        System.out.println(sessionFactory);    // one time need or not much necessarily needed

        // Now Initialize Session along With Transaction :-
        Session session = sessionFactory.openSession();     // session is a SHORTLIVED OBJECT
        Transaction txn = null;     // Trnsaction Declared

        try {
            txn = session.beginTransaction();
            session.persist(student1);  //save
            txn.commit();
            System.out.println(" Transaction Completed Successfully..!! ");


        }catch (Exception e) {
            // Transaction Handling :-
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }



    }
}
