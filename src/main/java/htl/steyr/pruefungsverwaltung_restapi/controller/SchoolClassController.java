package htl.steyr.pruefungsverwaltung_restapi.controller;

import htl.steyr.pruefungsverwaltung_restapi.model.SchoolClass;
import htl.steyr.pruefungsverwaltung_restapi.model.Student;
import htl.steyr.pruefungsverwaltung_restapi.model.repository.SchoolClassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/class")
public class SchoolClassController {

    /**
     * Schreiben Sie eine Methode, die nur über POST aufrufbar ist, sie soll
     * die Daten des Request entgegennehmen (Form -Data)
     * und alle Schüler der darin enthaltenen "schoolClass" ausgeben
     */

    @Autowired
    SchoolClassRepository repository;


    @PostMapping("/get")
    Set<Student> getStudents(@RequestParam String schoolclass){
        return repository.findSchoolClassBySchoolklasse(schoolclass).getStudents();
    }


    /**
     * Schreiben Sie eine Methode, die nur über POST abrufbar ist.
     * Sie soll den Namen einer Klasse (als from-data) entgegennehmen
     * und eine neue Klasse anlegen.
     * Der Rückgabewert ist true / false (bei Erfolg / Misserfolg)
     */

    @PostMapping("/create")
    Boolean create(@RequestParam String schoolclass){
        SchoolClass b = new SchoolClass();
        b.setSchoolklasse(schoolclass);
        try {
            repository.save(b);

        }catch (Exception e){
            return false;
        }
        return true;


    }

    @PostMapping("/create/new")
    Boolean createNewClass(@RequestBody SchoolClass newClass){
        boolean succes = false;


        //hier was machen

        newClass = repository.save(newClass);

        if(newClass.getId() > 0){
            succes = true;
        }

        return succes;

    }



}
