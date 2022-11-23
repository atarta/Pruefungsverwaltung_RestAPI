package htl.steyr.pruefungsverwaltung_restapi.model.repository;

import htl.steyr.pruefungsverwaltung_restapi.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
