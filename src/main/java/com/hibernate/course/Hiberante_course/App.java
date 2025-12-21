package com.hibernate.course.Hiberante_course;

import com.hibernate.course.Hiberante_course.Util.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "We are Going to learn Hibernate..! " );

        // create Student
        // SAVE : hibernate
        
        System.out.println(HibernateUtil.getsessionFactory());

    }
}
