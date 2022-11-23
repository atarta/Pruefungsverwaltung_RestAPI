package htl.steyr.pruefungsverwaltung_restapi.controller;

import htl.steyr.pruefungsverwaltung_restapi.model.Student;
import htl.steyr.pruefungsverwaltung_restapi.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository repository;

    @GetMapping("/list")
    public List<Student> list(){
        return repository.findAll();
    }

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello World";
    }

}
