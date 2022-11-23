package htl.steyr.pruefungsverwaltung_restapi.model.repository;

import htl.steyr.pruefungsverwaltung_restapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getStudentsByFirstNameAndLastName(String firstname, String lastname);


}
