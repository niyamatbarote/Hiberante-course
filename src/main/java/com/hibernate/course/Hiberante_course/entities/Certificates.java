package com.hibernate.course.Hiberante_course.entities;

//import com.sun.org.apache.xpath.internal.objects.XString;
import jakarta.persistence.*;

@Entity
@Table(name ="Certificates")
public class Certificates {

    @ManyToOne
    @JoinColumn(name = "StudId")
    private Student student;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Certificate_id;

    public int getCertificate_id() {
        return Certificate_id;
    }

    public void setCertificate_id(int certificate_id) {
        Certificate_id = certificate_id;
    }

    public String getTitle() {
        return Title;
    }

    public void setLink(String link) {
        Link = link;
    }

    public void setCert_about(String cert_about) {
        Cert_about = cert_about;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLink() {
        return Link;
    }

    private String Title;

    private String Link;

    public String getCert_about() {
        return Cert_about;
    }

    private String Cert_about;
}
