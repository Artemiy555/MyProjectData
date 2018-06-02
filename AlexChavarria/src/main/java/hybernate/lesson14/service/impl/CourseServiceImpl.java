package hybernate.lesson14.service.impl;

import hybernate.lesson14.dao.CourseDAO;
import hybernate.lesson14.dao.impl.CourseDAOImpl;
import hybernate.lesson14.entity.Course;
import hybernate.lesson14.service.CourseService;

/*public class CourseServiceImpl implements CourseService {

    *//*private CourseDAO courseDAO;

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
    public boolean delete(Course course){
        return false;
    }


}*/
