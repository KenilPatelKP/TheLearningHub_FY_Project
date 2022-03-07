package com.theelearninghub.initializers;

import com.theelearninghub.managers.CourseRepository;
import com.theelearninghub.managers.LessonRepository;
import com.theelearninghub.model.Course;
import com.theelearninghub.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

//@Service
//@DependsOn({"courseInitializer"})
public class LessonInitializer {

    @Autowired
    public LessonInitializer(CourseRepository courseRepository, LessonRepository lessonRepository) {

        Course course = courseRepository.findOneByTitle("The basics of C#");

        Stream.of(Lesson.builder().title("The begging")
                        .number(1)
                        .course(course)
                        .build(),
                Lesson.builder().title("The middle")
                        .number(2)
                        .course(course)
                        .build(),
                Lesson.builder().title("The end")
                        .number(3)
                        .course(course)
                        .build()
        ).forEach(lesson -> lessonRepository.save(lesson));
    }
}
