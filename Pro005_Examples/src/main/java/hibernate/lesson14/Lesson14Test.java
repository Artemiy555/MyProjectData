package hibernate.lesson14;

import hibernate.lesson14.entity.Course;
import hibernate.lesson14.entity.Group;
import hibernate.lesson14.service.CourseService;
import hibernate.lesson14.service.impl.CourseServiceImpl;
import hibernate.lesson14.service.impl.GroupService;
import hibernate.lesson14.service.impl.GroupServiceImpl;
import hibernate.lesson14.util.HibernateUtil;

import java.util.Calendar;

public class Lesson14Test {

    public static void main(String[] args) {

        CourseService courseService = new CourseServiceImpl();
        GroupService groupService = new GroupServiceImpl();

        Course course1 = courseService
                .create("Course 1", "Description 1");
        Course course2 = courseService
                .create("Course 2", "Description 2");

        Group group1 = groupService
                .create(course1, "Group 1 - CRS 1",
                        Calendar.getInstance().getTime(),
                        Calendar.getInstance().getTime());

        Group group2 = groupService
                .create(course1, "Group 2 - CRS 2",
                        Calendar.getInstance().getTime(),
                        Calendar.getInstance().getTime());

        HibernateUtil.getFactory().close();
    }
}
