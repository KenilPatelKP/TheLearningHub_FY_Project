package com.theelearninghub.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`admin`")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idadmin;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "admin")
    private List<User> users;
    @OneToMany(mappedBy = "admin")
    private List<Course> courses;
    @OneToMany(mappedBy = "admin")
    private List<Room> rooms;

}