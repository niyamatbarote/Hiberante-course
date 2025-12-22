package com.hibernate.course.Hiberante_course;

import com.hibernate.course.Hiberante_course.Util.HibernateUtil;
import com.hibernate.course.Hiberante_course.entities.Certificates;
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
        student1.setStandard("BE");
        student1.setScore(8.0);
        student1.setAbout("He is a Bright Student");


        Student student2 = new Student();
        student2.setName("Pranav");
        student2.setRollNum(2);
        student2.setCollege("Alard College of Engg");
        student2.setStandard("TE");
        student2.setScore(9.5);
        student2.setAbout("He Goes to Gym..!!");

        Certificates cert1 = new Certificates();
        cert1.setTitle("Java Certficate");
        cert1.setLink("www.scaler.com");
        cert1.setCert_about("This is Java Certificate. ");
        cert1.setStudent(student1);
        student1.getCertificates().add(cert1);

        Certificates cert2 = new Certificates();
        cert2.setTitle("Python Certficate");
        cert2.setLink("www.greatlearning.com");
        cert2.setCert_about("You performed very good ");
        cert2.setStudent(student2);
        student2.getCertificates().add(cert2);
// Assign Certificates to Students :-


// Receive Certificate as a Student :-
//        student1.getCertificates().add(cert1);





        // SessionFactory is a LONG-LIVED OBJECT
        SessionFactory sessionFactory = HibernateUtil.getsessionFactory(); // Session Creation
//        System.out.println(sessionFactory);    // one time need or not much necessarily needed

        // Now Initialize Session along With Transaction :-
        Session session = sessionFactory.openSession();     // session is a SHORTLIVED OBJECT
        Transaction txn = null;     // Trnsaction Declared

        try {
            txn = session.beginTransaction();
            session.persist(student1);  //save
            session.persist(student2);
            // It is not required to persist the Certificates as Student is Parent//
//            session.persist(cert1);
//            session.persist(cert2);

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
