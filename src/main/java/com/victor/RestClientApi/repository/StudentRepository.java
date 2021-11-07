package com.victor.RestClientApi.repository;


import com.victor.RestClientApi.model.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

//     @Query("SELECT s FROM Student  s WHERE s.email=?1")
    Optional<Student>findStudentByEmail(String email);

    List<Student>findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String keyword, Sort sort);

//    @Query("FROM Student WHERE firstName = :firstName OR phoneNumber = :phoneNumber")
    @Query("select s FROM  Student  s where s.firstName=?1 or s.phoneNumber=?2")
    List<Student> getStudentByFirstNameAndPhoneNumber(String firstName, String phoneNumber);

    @Modifying
    @Query("DELETE from Student where firstName= :firstName")
    Integer deleteStudentByFirstName(String firstName);

}
