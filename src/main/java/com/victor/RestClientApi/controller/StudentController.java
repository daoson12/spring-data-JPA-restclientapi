package com.victor.RestClientApi.controller;


import com.victor.RestClientApi.model.Student;
import com.victor.RestClientApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }



    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return new ResponseEntity<List<Student>>(studentService.getAllStudents(pageNumber,pageSize), HttpStatus.OK);
    }

    @GetMapping("/student/filterByName")
    public ResponseEntity<List<Student>>getStudentByFirstName(@RequestParam String firstName){
        return new ResponseEntity<List<Student>>((List<Student>) studentService.getStudentByFirstName(firstName ), HttpStatus.OK);
    }

    @GetMapping("/student/{firstName}/{phoneNumber}")
    private ResponseEntity<List<Student>> getStudentByFirstNameAndPhone(@PathVariable String firstName, @PathVariable String phoneNumber){
        return new ResponseEntity<List<Student>>(studentService.getStudentByFirstNameAndPhoneNumber(firstName,phoneNumber),HttpStatus.OK);
    }

    @GetMapping("/student/getFirstNameContaining")
    public ResponseEntity<List<Student>> getStudentFirstNameContaining(@RequestParam String firstName){
 return new ResponseEntity<List<Student>>(studentService.getStudentFirstNameContaining(firstName), HttpStatus.OK);

    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> getStudents(@PathVariable("studentId") Long id) {
        return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student ){
        return new ResponseEntity<Student>( studentService.saveStudent(student), HttpStatus.CREATED) ;
    }


    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteStudentById(@RequestParam Long id){

       return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("delete/{firstName}")
    public ResponseEntity<String> deleteStudentByName(@PathVariable String firstName){
        return new ResponseEntity<String>( studentService.deleteStudentByName(firstName)+"No of records deleted",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
       student.setId(id);
        return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
    }

}
