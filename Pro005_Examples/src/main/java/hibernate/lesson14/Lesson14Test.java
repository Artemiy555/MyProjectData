package hibernate.lesson14;

import hibernate.lesson14.entity.Course;
import hibernate.lesson14.service.CourseService;
import hibernate.lesson14.service.impl.CourseServiceImpl;
import hibernate.lesson14.util.HibernateUtil;

public class Lesson14Test {

    public static void main(String[] args) {

        CourseService courseService = new CourseServiceImpl();

        Course course1 = courseService
                .create("Course 1", "Description 1");
        Course course2 = courseService
                .create("Course 2", "Description 2");

        HibernateUtil.getFactory().close();
    }
}
