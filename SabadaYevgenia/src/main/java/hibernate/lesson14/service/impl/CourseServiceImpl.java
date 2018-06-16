package hibernate.lesson14.service.impl;

import hibernate.lesson14.dao.CourseDoa;
import hibernate.lesson14.dao.impl.CourseDaoImpl;
import hibernate.lesson14.entity.Course;
import hibernate.lesson14.service.CourseService;

import java.util.Date;

public class CourseServiceImpl implements CourseService {
    private CourseDoa courseDoa;
    public CourseServiceImpl(){
        courseDoa=new CourseDaoImpl();
        }

    @Override
    public Course create(String title, String description) {
        if (title != null & description != null) {
           Course course = new Course(title, description);
            course.setId(courseDoa.create(course));
            return course;
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (id !=null){
            courseDoa.delete(id);
        }
        return  false;
    }


}

