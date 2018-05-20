package hibernate.lesson14.service;

import hibernate.lesson14.entity.Course;

public interface CourseService {

    Course create(String title, String description);

}
