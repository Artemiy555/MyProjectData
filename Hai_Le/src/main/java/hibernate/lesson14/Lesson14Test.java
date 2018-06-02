package hibernate.lesson14;

import hibernate.lesson14.entity.Course;
import hibernate.lesson14.service.CourseService;
import hibernate.lesson14.service.impl.CourseServiceImpl;
import hibernate.lesson14.util.HibernateUtil;

public class Lesson14Test {

    public static void main(String[] args) {
        CourseService courseService = new CourseServiceImpl();

        Course course01 = courseService
                .create("Course_01", "Description_01");
        Course course02 = courseService
                .create("Course_02", "Description_02");


        HibernateUtil.getFactory().close();
    }

}
