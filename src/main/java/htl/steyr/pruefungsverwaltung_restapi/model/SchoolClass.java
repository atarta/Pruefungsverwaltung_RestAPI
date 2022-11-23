package htl.steyr.pruefungsverwaltung_restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Set;

@EnableAutoConfiguration
@Entity
@Table(name = "schoolclass")
public class SchoolClass {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "schoolklasse", nullable = false)
    private String schoolklasse;


    @OneToMany(mappedBy = "schoolClass", fetch = FetchType.LAZY)
    private Set<Student> students;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolklasse() {
        return schoolklasse;
    }

    public void setSchoolklasse(String schoolklasse) {
        this.schoolklasse = schoolklasse;
    }



    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return schoolklasse;
    }
}
