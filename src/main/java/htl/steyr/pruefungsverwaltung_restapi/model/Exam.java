package htl.steyr.pruefungsverwaltung_restapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Set;

@EnableAutoConfiguration
@Entity
@Table(name = "exam")
public class Exam {


    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "pruefung", nullable = false)
    private String pruefung;



    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
    private Set<Grade> grades;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;


    public String getPruefung() {
        return pruefung;
    }

    public void setPruefung(String pruefung) {
        this.pruefung = pruefung;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long fach) {
        this.id = fach;
    }


    @Override
    public String toString() {
        return pruefung;
    }
}
