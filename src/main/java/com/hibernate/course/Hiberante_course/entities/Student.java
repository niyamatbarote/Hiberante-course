package com.hibernate.course.Hiberante_course.entities;

//import com.sun.tools.javac.comp.Resolve;
import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long StudId;

    @Column(name = "StudName", length = 255, unique = false)
    private String Name;

    @Column(name = "RollCall", unique = true, nullable = false)
    private int RollNum;

    private String College;

    private int Score;

    private int Class;  // Class need to be Capital Initials, not smaller one

    @Lob    // ( Large objects ) Used to stored Large amount of INfo
    private String about;
}
