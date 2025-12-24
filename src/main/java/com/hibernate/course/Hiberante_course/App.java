package com.hibernate.course.Hiberante_course;

import com.hibernate.course.Hiberante_course.Util.HibernateUtil;
import com.hibernate.course.Hiberante_course.entities.Certificates;
import com.hibernate.course.Hiberante_course.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.println( "We are Going to Perform CRUD Ops..! " );
        StudentManagement sm = new StudentManagement();

        boolean cont = true;
        while(cont) {
        int choice;
        System.out.println("\n=======Student Management======");
        System.out.println("1. Insert/Create Student : ");
        System.out.println("2. Search/Read Student : ");
        System.out.println("3. Update Student : ");
        System.out.println("4. Delete Student : ");
        System.out.println("5. Exit \n");
        System.out.println("Enter Your Choice: ");

        choice = sc.nextInt();

            switch (choice) {
                case 1: // Insert
                    sm.insertStud();
                    break;

                case 2: // Search/Read
                    System.out.println("Enter The student ID to GET Information About Student: ");
//                    int myId = sc.nextInt();
//                    sc.nextLine();
                    Student student1 = sm.getById(sc.nextLong());

                    if (student1 == null) {
                        System.out.println("Student Not Found..!!");
                    } else {
                        System.out.println("Student id: " + student1.getStudId());
                        System.out.println("Student Name: " + student1.getName());
                        System.out.println("Student College: " + student1.getCollege());
                        System.out.println("Student Standard: " + student1.getStandard());
                        System.out.println("Student Result: " + student1.getScore());
                        System.out.println("Student About: " + student1.getAbout());
                    System.out.println("Student id: "+ student1.getCertificates() );
                    }
//                sm.getById(myId);
                    break;

                case 3: // Update Student
                    System.out.println("Enter The student ID to UPDATE Information About Student: ");
                    int upID = sc.nextInt();
                    sc.nextLine();
                    Student student = sm.getById(upID);
                    sm.updateStudent(upID);
                    break;

                case 4: // Delete :
                    System.out.println("Enter The student ID to DELETE Information About Student: ");
                    int delId = sc.nextInt();
                    sc.nextLine();
                    sm.deleteStud(delId);
                    break;

                case 5: // Exit
                    cont = false;
                    System.out.println(" Exititng ..!! ");
                    break;

                default:
                    System.out.println("Invalid Choice.. ");

            }
        }























        // create Student
        // SAVE : hibernate

        // Create student Object:-
//        Student student1 = new Student();
//        student1.setName("Naman");
//        student1.setRollNum(3);
//        student1.setCollege("Alard College of Management");
//        student1.setStandard("BE");
//        student1.setScore(9.8);
//        student1.setAbout("He is a Smart Student");
//
//
//        Student student2 = new Student();
//        student2.setName("Rushikesh");
//        student2.setRollNum(4);
//        student2.setCollege("MIT");
//        student2.setStandard("SE");
//        student2.setScore(9.8);
//        student2.setAbout("He Got a Job..!!");
//
//        Certificates cert1 = new Certificates();
//        cert1.setTitle("Generative AI");
//        cert1.setLink("www.scaler.com");
//        cert1.setCert_about("This is AI Certificate. ");
//        cert1.setStudent(student1);
//        student1.getCertificates().add(cert1);
//
//        Certificates cert2 = new Certificates();
//        cert2.setTitle("ML Certficate");
//        cert2.setLink("www.greatlearning.com");
//        cert2.setCert_about("You did very good ");
//        cert2.setStudent(student2);
//        student2.getCertificates().add(cert2);

// Assign Certificates to Students :-
// Receive Certificate as a Student :-






        // SessionFactory is a LONG-LIVED OBJECT
//        SessionFactory sessionFactory = HibernateUtil.getsessionFactory(); // Session Creation
//        System.out.println(sessionFactory);    // one time need or not much necessarily needed

        // Now Initialize Session along With Transaction :-
//        Session session = sessionFactory.openSession();     // session is a SHORTLIVED OBJECT
//        Transaction txn = null;     // Trnsaction Declared

//        try {
//            txn = session.beginTransaction();
//            session.persist(student1);  //save
//            session.persist(student2);
//            // It is not required to persist the Certificates as Student is Parent//
////            session.persist(cert1);
////            session.persist(cert2);
//
//            txn.commit();
//            System.out.println(" Transaction Completed Successfully..!! ");
//
//
//        }catch (Exception e) {
//            // Transaction Handling :-
//            if (txn != null) {
//                txn.rollback();
//            }
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
    }
}
