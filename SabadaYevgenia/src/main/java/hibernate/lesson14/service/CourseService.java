package hibernate.lesson14.service;

import hibernate.lesson14.entity.Course;

import java.util.Date;

public interface CourseService {

    Course create(String title, String description);
    boolean deleteById(Long id);


}
