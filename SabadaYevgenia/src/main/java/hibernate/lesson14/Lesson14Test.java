package hibernate.lesson14;

import hibernate.lesson14.entity.Course;
import hibernate.lesson14.service.CourseService;
import hibernate.lesson14.service.CourseServiceImpl;

public class Lesson14Test {
    public static void main(String[] args) {
        CourseService courseService=new CourseServiceImpl();

        Course course1=courseService.creat()
    }
}
