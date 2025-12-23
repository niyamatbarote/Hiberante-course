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
            String name = sc.nextLine();
            sc.nextInt();
            stud.setName(name);
            System.out.println("Enter RollNum of the Student : ");
            int num = sc.nextInt();
            sc.nextInt();
            stud.setRollNum(num);
            System.out.println("Enter College Name: ");
            String clg = sc.nextLine();
            sc.nextInt();
            stud.setCollege(clg);
            System.out.println("Enter Standard : ");
            String std = sc.nextLine();
            sc.nextInt();
            stud.setStandard(std);
            System.out.println("Enter Score: ");
            double score = sc.nextInt();
            sc.nextInt();
            stud.setScore(score);
            System.out.println("Enter About Student : ");
            String about = sc.nextLine();
            sc.nextInt();
            stud.setAbout(about);

            session.persist(stud);
            txn4.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2) READ :
    public Student getById(long StudeId) {

        try(Session session = sessionFactory.openSession()) {
            Student student1 = session.getReference(Student.class, StudeId);
            return student1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 3) UPDATE :
    public Student updateStudent(long StudId, Student student) {
        try(Session session = sessionFactory.openSession()) {
            Transaction txn2 = session.beginTransaction();
            Student student2 = session.getReference(Student.class, StudId);
            if (student2 != null) {
                student2.setName(student.getName());
                student2.setCollege(student.getCollege());
                student2.setRollNum(student.getRollNum());
                student2.setStandard(student.getStandard());
                student2.setScore(student.getScore());
                student2.setAbout(student.getAbout());

                session.merge(student2);
            }
            txn2.commit();
            return student2;
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
