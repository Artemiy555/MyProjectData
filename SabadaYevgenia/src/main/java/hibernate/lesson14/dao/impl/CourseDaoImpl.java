package hibernate.lesson14.dao.impl;


import hibernate.lesson14.dao.CourseDoa;
import hibernate.lesson14.entity.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.SequenceGenerator;
import java.util.List;

public class CourseDaoImpl implements CourseDoa {

    private SessionFactory factory;

    public CourseDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Course course) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            Long id=(Long)session.save(course);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException exc){
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