package com.theelearninghub.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcourse;
    private String title;
    private String duration;
    private String syllabus;
    private Double price;
    private String description;
    private String category;
    private String level;
    private boolean validated;
    private boolean highlighted;
    @Column(length = 1_000_000)
    private byte[] photoBinary;
    private boolean isPrivate;
    @ManyToOne
    @JoinColumn(name = "CreatorId", referencedColumnName = "iduser", nullable = false)
    private User creator;
    @ManyToOne
    @JoinColumn(name = "AdminId", referencedColumnName = "idadmin", nullable = false)
    private Admin admin;
    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;
    @ManyToMany(mappedBy = "attends")
    private List<User> isAttendedBy;
    @ManyToMany(mappedBy = "wishes")
    private List<User> isWishedBy;

}
