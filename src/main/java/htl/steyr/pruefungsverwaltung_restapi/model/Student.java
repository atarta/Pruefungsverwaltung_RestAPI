package htl.steyr.pruefungsverwaltung_restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@EnableAutoConfiguration
@Entity
@Table(name = "student")
public class Student {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "vorname", nullable = false)
    private String firstName;

    @Column(name = "nachname", nullable = false)
    private String lastName;

    @Column(name = "geburtsdatum", nullable = false)
    private Date birthdate;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Grade> grades;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolklasse_id")
    private SchoolClass schoolClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString() {
        return id +" " + firstName +" " + lastName + " " +schoolClass;
    }

}
