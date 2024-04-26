package com.project.EventManagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Ticket ticket;

}

/*
Student model will have-
StudentId
first name
last name
age
department


I have added validation on age(between 18 -25) ,
first name(first letter should be capital) ,
 department(datatype of variable department should be Enum and not string Enum should support department names line ME , ECE , civil , CSE).

 */