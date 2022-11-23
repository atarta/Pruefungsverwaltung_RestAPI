package htl.steyr.pruefungsverwaltung_restapi.model;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Set;

@EnableAutoConfiguration
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "fach", nullable = false)
    private String fach;





    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private Set<Exam> exams;

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }


    public String getFach() {
        return fach;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return fach;
    }
}
