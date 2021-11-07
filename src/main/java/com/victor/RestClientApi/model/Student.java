package com.victor.RestClientApi.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "tbl_student")
public class Student {




    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Name should not be empty")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "Surname should not be empty")
    @Column(name = "surname")
    private String surname;


    @Column(name = "age")
    private int age;

    @NotBlank(message = "phoneNumber should not be empty")
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotBlank(message = "address should not be empty")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "studentNumber should not be empty")
    @Column(name = "studentNumber")
    private String studentNumber;

    @NotBlank(message = "email should not be empty")
    @Column(name = "email")
    private String email;


//    @NotEmpty(message = "date of birth should not be empty")
    @Column(name = "dob")
    private LocalDate dob;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false, updatable = false)
    private Date createdAt;

    @CreationTimestamp
    @Column(name = "updateAt")
    private Date updateAt;

    public Student() {
    }

    public Student(long id, String firstName, String surname, int age, String phoneNumber, String address, String studentNumber, String email, LocalDate dob, Date createdAt, Date updateAt) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.studentNumber = studentNumber;
        this.email = email;
        this.dob = dob;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }

}
