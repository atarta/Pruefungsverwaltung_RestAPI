package htl.steyr.pruefungsverwaltung_restapi.model;

import htl.steyr.pruefungsverwaltung_restapi.PruefungsverwaltungRestApiApplication;
import htl.steyr.pruefungsverwaltung_restapi.model.repository.SubjectRepository;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
// Wir müssen dem Test sagen, von wo der Ausgangspunkt ist. Alles unter dieser Klasse
// wird auf Entities und alles drum und dran kontrolliert.
@SpringBootTest(classes = PruefungsverwaltungRestApiApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SubjectTest {
    Subject subject = new Subject();

    @Autowired
    private SubjectRepository subjectRepository;

    @Order(1)
    @Test
    public void setTitle() {
        Assertions.assertDoesNotThrow(() -> {
            subject.setFach("Wirtschaft");
            subjectRepository.save(subject);
        });
    }

    @Order(2)
    @Test
    public void update() {
        Assertions.assertDoesNotThrow(() -> {
            Subject toUpdateSubject = subjectRepository.getReferenceById(subject.getId());
            subject.setFach("WIRTSCHAFT");
            subjectRepository.save(subject);
        });
    }

    @Order(3)
    @Test
    public void delete() {
        Assertions.assertDoesNotThrow(() -> {
            Subject toDeleteSubject = subjectRepository.getReferenceById(subject.getId());
            subjectRepository.delete(toDeleteSubject);
        });
    }
}