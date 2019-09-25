package group;

import group.dao.*;
import group.dao.impl.*;
import group.entily.*;
import group.service.*;
import group.service.impl.*;
import hibernate.Util.HibernateUtil;

import java.util.Calendar;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        CourseService courseService = new CourseServiceImpl();
        CourseDao courseDao = new CourseDAOImpl();

        HibernateUtil.getFactory().close();

        GroupService groupService = new GroupServiceImpl();
        GroupDao groupDao = new GroupDAOImpl();

        StudentServise studentServise = new StudentServiseImpl();
        StudentDao studentDao = new StudentDAOImpl();

        RatingSecondCourseService ratingSecondCourseService = new RatingSecondCourseServiceImpl();
        RatingSecondCourseDao ratingSecondCourse= new RatingSecondCourseDAOImpl();

        RatingFirstCourseService ratingFirstCourseService = new RatingFirstCourseServiceImpl();
        RatingFirstCourseDao ratingFirstCourse= new RatingFirstCourseDAOImpl();

        Course course1 = courseService
                .create("Course 1", "Description 1");
        Course course2 = courseService
                .create("Course 2", "Description 2");
        Course course3 = courseService
                .create("Course 3", "Description 3");


        Group group1 = groupService
                .create(course1, "Group 1 - CRS 1",
                        Calendar.getInstance().getTime(),
                        Calendar.getInstance().getTime());

        Group group2 = groupService
                .create(course1, "Group 2 - CRS 1",
                        Calendar.getInstance().getTime(),
                        Calendar.getInstance().getTime());

        Group group3 = groupService
                .create(course1, "Group 2 - CRS 1",
                        Calendar.getInstance().getTime(),
                        Calendar.getInstance().getTime());

        Student student1 = studentServise.create(group1,"Artemiy3");
        Student student2 = studentServise.create(group1,"Vlad1");
        Student student3 = studentServise.create(group1,"Dolik3");

        ratingSecondCourseService.create(student1,"75","75");
        ratingSecondCourseService.create(student2,"80","80");
        ratingSecondCourseService.create(student3,"67","78");

        ratingFirstCourseService.create(student1,"75","75");
        ratingFirstCourseService.create(student2,"80","80");
        ratingFirstCourseService.create(student3,"67","78");

        group1.getStudents().add(student1);
        group2.getStudents().add(student2);
        group3.getStudents().add(student3);


        course1.getGroups().add(group1);
        course2.getGroups().add(group2);
        course3.getGroups().add(group3);

        courseService.update(course1);
        courseService.update(course2);
        courseService.update(course3);

//        groupDao.findAll();
//        courseDao.findAll();
        System.out.println("/////////////////////////////////////////////////////");
        try {

        List<Course> list = courseDao.findAll();
        System.out.println(list);
        for (Course a : list) {
            System.out.println(a.getId() + "    "  + a.getDescription()+ "    " + a.getTitle());
        }}catch (Exception e){
            e.printStackTrace();
        }

        List<Group> list1 = groupDao.findAll();
        for (Group a : list1) {
            System.out.println(a.getId() + "    " + a.getTitle() +
                     "    " + a.getBegin()+ " " + a.getEnd());
        }

        List<Student> list2 = studentDao.findAll();
        for (Student a : list2) {
            System.out.println(a.getFullName() + "    " + a.getGroupId().getId() +
                    "     " + a.getIdRating());
        }

        List<RatingFirstCourse> list3 = ratingFirstCourse.findAll();
        for (RatingFirstCourse a : list3) {

            System.out.println( a.getRatingMach() +
                    "     " + a.getRatingProg());

        }
        System.out.println("******");
        List<RatingSecondCourse> list4 = ratingSecondCourse.findAll();
        for (RatingSecondCourse a : list4) {
            System.out.println(a.getRatingMach() +
                    "     " + a.getRatingProg());
        }


        System.out.println("/////////////////////////////////////////////////////");
       // studentDao.findAll();
       // List<Student> list = session.createCriteria(Student.class).list();


        HibernateUtil.getFactory().close();


    }


}
