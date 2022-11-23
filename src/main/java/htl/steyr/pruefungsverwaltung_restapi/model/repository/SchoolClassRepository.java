package htl.steyr.pruefungsverwaltung_restapi.model.repository;

import htl.steyr.pruefungsverwaltung_restapi.model.SchoolClass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {


    //@Query(value = )

    @Query("SELECT s FROM SchoolClass sc "+
            "inner join Student s on (s.schoolClass = sc)"+
            " inner join Grade g on (g.student = s)"+
            "where g.grade >= 5")
    List<SchoolClass> getAllClassesWithNegativeStudents();

    SchoolClass findSchoolClassBySchoolklasse(String schoolklasse);

}
