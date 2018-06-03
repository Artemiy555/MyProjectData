package hybernate.lesson14.dao.impl;

import hybernate.lesson14.util.HibernateUtil;
import hybernate.lesson14.dao.CourseDAO;
import hybernate.lesson14.entity.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    private SessionFactory factory;

    public CourseDAOImpl(){
        factory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(Course course) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(course);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException exc) {
            return null;
        }
    }

    @Override
    public Course read(Long id) {
        return null;
    }

    @Override
    public boolean update(Course course) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }
}
