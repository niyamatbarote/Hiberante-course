package com.hibernate.course.Hiberante_course.entities;

//import com.sun.tools.javac.comp.Resolve;
//import com.sun.org.apache.xml.internal.security.keys.content.X509Data;
import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {

    public List<Certificates> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificates> certificates) {
        this.certificates = certificates;
    }

    // Cascade.ALL means if we delete the stud, all cert related to him will be deleted.
    // orphanRemoval = true, means removal from one table is related to other table, eg- student, cert..
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Certificates> certificates = new ArrayList<>();

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

    @Column(name = "RollCall", nullable = false)
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

    @Lob    // ( Large objects ) Used to stored Large amount of INformatio
    private String About;

    public String getAbout() {
        return About;
    }
    public void setAbout(String abt) {
        this.About = abt;
    }


}
