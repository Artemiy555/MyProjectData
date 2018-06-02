package hybernate.lesson14.service;

import hybernate.lesson14.entity.Course;

public interface CourseService {

    Course create(String title, String description);

    Boolean delete(Course course);
}
