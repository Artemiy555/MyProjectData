package hibernate.lesson14.service.impl;

import hibernate.lesson14.dao.CourseDAO;
import hibernate.lesson14.dao.impl.CourseDAOImpl;
import hibernate.lesson14.entity.Course;
import hibernate.lesson14.service.CourseService;

public class CourseServiceImpl implements CourseService {

    private CourseDAO courseDAO;

    public CourseServiceImpl() {
        courseDAO = new CourseDAOImpl();
    }

    @Override
    public Course create(String title, String description) {
        if (title != null & description != null) {
            Course course = new Course(title, description);
            course.setId(courseDAO.create(course));
            return course;
        }
        return null;
    }

    @Override
    public boolean update(Course course) {
        if (course != null) {
            return courseDAO.update(course);
        }
        return false;
    }

    @Override
    public boolean delete(Course course) {
        if (course != null) {
            return courseDAO.delete(course);
        }
        return false;
    }
}
