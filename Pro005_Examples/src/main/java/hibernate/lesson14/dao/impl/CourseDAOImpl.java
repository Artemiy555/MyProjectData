package hibernate.lesson14.dao.impl;

import hibernate.lesson14.util.HibernateUtil;
import hibernate.lesson14.dao.CourseDAO;
import hibernate.lesson14.entity.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    private SessionFactory factory;

    public CourseDAOImpl() {
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
        } catch (HibernateException exc) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Course read(Long id) {
        Session session = factory.openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }

    @Override
    public boolean update(Course course) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exc) {
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Course course) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(course);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exc) {
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Course> findAll() {
        return null;
    }
}
