package hibernate.lesson14.service;

import hibernate.lesson14.dao.CourseDoa;
import hibernate.lesson14.dao.impl.CourseDaoImpl;
import hibernate.lesson14.entity.Course;

public class CourseServiceImpl extends CourseService {
    private CourseDoa courseDoa;
    public CourseServiceImpl(){
        courseDoa=new CourseDaoImpl();
        }
        @Override
    public Course reate(String title, String description){
        if(title!=null&description!=null){
            Course course=new Course(title,description);
            course.setId(courseDoa.create(course));
            return course;
        }
        return null;
        }
    }

