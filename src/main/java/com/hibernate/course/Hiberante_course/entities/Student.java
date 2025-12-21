package com.hibernate.course.Hiberante_course.entities;

//import com.sun.tools.javac.comp.Resolve;
import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long StudId;

    public long getStudId() {
        return StudId;
    }
    private void setStudId(long studid) {
        this.StudId = studid;
    }

    @Column(name = "StudName", length = 255, unique = false)
    private String Name;

    public void setName(String name) {
        this.Name = name;
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
        this.RollNum = roll;
    }

    private String College;

    public String getCollege() {
        return College;
    }
    public void setCollege(String clg) {
        this.College = clg;
    }

    private double Score;

    public double getScore() {
        return Score;
    }
    public void setScore(double scr) {
        this.Score = scr;
    }

    private String Standard;  // Class need to be Capital Initials, not smaller one

    public String getStandard() {
        return Standard;
    }
    public void setStandard(String std) {
        this.Standard = std;
    }

    @Lob    // ( Large objects ) Used to stored Large amount of INfo
    private String About;

    public String getAbout() {
        return About;
    }
    public void setAbout(String abt) {
        this.About = abt;
    }
}
