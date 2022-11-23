package htl.steyr.pruefungsverwaltung_restapi.model.repository;

import htl.steyr.pruefungsverwaltung_restapi.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GradeRepository extends JpaRepository<Grade, Long> {
}
