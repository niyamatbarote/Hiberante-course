package com.hibernate.course.Hiberante_course;

import com.hibernate.course.Hiberante_course.Util.HibernateUtil;
import com.hibernate.course.Hiberante_course.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    Scanner sc = new Scanner(System.in);
    private SessionFactory sessionFactory = HibernateUtil.getsessionFactory();

    // Let's Perform CRUD Ops :-
    // 1) SAVE:
    public void saveStudent(Student Student) {

        // opening session in try() will make it session.close automatically
        try (Session session = sessionFactory.openSession()) {
            Transaction txn1 = session.beginTransaction();
            session.persist(Student);
            txn1.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // INSERT :
    public void insertStud() {
        try {
            Session session = sessionFactory.openSession();
            Transaction txn4 = session.beginTransaction();

            Student stud = new Student();

            System.out.println("Enter Name of the Student: ");
            stud.setName(sc.nextLine());

            System.out.println("Enter RollNum of the Student : ");
            stud.setRollNum(sc.nextInt());
            sc.nextLine();

            System.out.println("Enter College Name: ");
            stud.setCollege(sc.nextLine());

            System.out.println("Enter Standard : ");
            stud.setStandard(sc.nextLine());

            System.out.println("Enter Score: ");
            stud.setScore(sc.nextDouble());
            sc.nextLine();

            System.out.println("Enter About Student : ");
            stud.setAbout(sc.nextLine());

            session.persist(stud);
            txn4.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2) READ :
    public void getById(long StudId) {

        try(Session session = sessionFactory.openSession()) {
            Student student1 = session.find (Student.class, StudId);
            System.out.println(student1.getName());
            System.out.println(student1.getCollege());
            System.out.println(student1.getRollNum());
            System.out.println(student1.getStandard());
            System.out.println(student1.getScore());
            System.out.println(student1.getAbout());
            System.out.println(student1.getCertificates());
        }
    }

    // 3) UPDATE :
    public void updateStudent(long studId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction txn = session.beginTransaction();
            Student s = session.getReference(Student.class, studId);

            if (s == null) {
                System.out.println("Student not found!");
                return;
            }

            System.out.print("Enter New Name: ");
            s.setName(sc.nextLine());

            System.out.print("Enter New College: ");
            s.setCollege(sc.nextLine());

            System.out.print("Enter New Standard: ");
            s.setStandard(sc.nextLine());

            System.out.print("Enter New Score: ");
            s.setScore(sc.nextDouble());
            sc.nextLine();

            System.out.print("Enter New About: ");
            s.setAbout(sc.nextLine());

            txn.commit();
            System.out.println("Student Updated Successfully!");
        }
    }

    // 4) DELETE :
    public void deleteStud(long StudId) {
        try(Session session = sessionFactory.openSession()) {
            Transaction txn3 = session.beginTransaction();
            Student student3 = session.getReference(Student.class, StudId);
            if (student3 != null) {
                session.remove(student3);
            }
            txn3.commit();
            System.out.println("Deleted Student Succsessfully..!!");
        }
    }

    // HQL [JPA] --> Native Query
    // Database Independent

    // Get All the Student Using HQL :-
    public List<Student> getAllStudents( ) {
        try (Session session = sessionFactory.openSession()) {
            String myHQL = "FROM Student";
            Query<Student> query = session.createQuery(myHQL, Student.class);
            return query.list();
        }
    }

    // Get Student By Name :-
    public Student getByName(String Name) {
        try(Session session = sessionFactory.openSession()) {
            String setHQL = "FROM Student WHERE Name = :StudName";
            Query<Student> query = session.createQuery(setHQL, Student.class);
            query.setParameter("StudName", Name);
            return query.uniqueResult();
        }
    }
}
