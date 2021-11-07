package com.victor.RestClientApi.service;



import com.victor.RestClientApi.model.Student;
import com.victor.RestClientApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


   private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(int pageNumber, int pageSize){

        Pageable pageable= PageRequest.of(pageNumber,pageSize, Sort.Direction.DESC,"id");
      return studentRepository.findAll(pageable).getContent();
  }



  public Student saveStudent(Student student){
     Optional<Student> studentEmail = studentRepository
             .findStudentByEmail(student.getEmail());
     if (studentEmail.isPresent()){
         throw  new IllegalStateException("student with this email " +
                 "already exist");
     }
     var dob = student.getDob();
     var age=Period.between(dob, LocalDate.now()).getYears();
     student.setAge(age);
      return studentRepository.save(student);
  }

  public Student getStudentById(Long id){
      Optional<Student> student=studentRepository.findById(id);
      if (student.isPresent()) {
           return student.get();
      }
      throw new RuntimeException("Student is not found for the id" + id);
    }

    public  List<Student> getStudentByFirstName(String firstName){

       return studentRepository.findByFirstName(firstName);

    }

    public void deleteStudentById(Long id){
         studentRepository.deleteById(id);

    }

    public Student updateStudent( Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> getStudentFirstNameContaining(String firstName){

        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        return studentRepository.findByFirstNameContaining(firstName, sort);
    }

    public  List<Student> getStudentByFirstNameAndPhoneNumber(String firstName, String phoneNumber){
        return studentRepository.getStudentByFirstNameAndPhoneNumber(firstName,phoneNumber);
    }

    public Integer deleteStudentByName (String firstName){
        return  studentRepository.deleteStudentByFirstName(firstName);
    }
}



