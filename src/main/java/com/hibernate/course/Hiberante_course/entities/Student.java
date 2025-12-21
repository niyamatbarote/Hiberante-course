package com.hibernate.course.Hiberante_course.entities;

//import com.sun.tools.javac.comp.Resolve;
import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long StudId;

    public long getStudId() {
        return StudId;
    }
    private void setStudId(long studid) {
        StudId = studid;
    }

    @Column(name = "StudName", length = 255, unique = false)
    private String Name;

    public void setName(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }

    @Column(name = "RollCall", unique = true, nullable = false)
    private int RollNum;

    public int getRollNum () {
        return RollNum;
    }
    public void setRollNum(int roll) {
        RollNum = roll;
    }

    private String College;

    public String getCollege() {
        return College;
    }
    public void setCollege(String clg) {
        College = clg;
    }

    private int Score;

    public int getScore() {
        return Score;
    }
    public void setScore(int scr) {
        Score = scr;
    }

    private int Standard;  // Class need to be Capital Initials, not smaller one

    public int getStandard() {
        return Standard;
    }
    public void setStandard(int std) {
        Standard = std;
    }

    @Lob    // ( Large objects ) Used to stored Large amount of INfo
    private String About;

    public String getAbout() {
        return About;
    }
    public void setAbout(String abt) {
        About = abt;
    }
}
