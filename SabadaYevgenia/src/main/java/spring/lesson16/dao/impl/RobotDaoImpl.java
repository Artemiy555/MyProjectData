package spring.lesson16.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.lesson16.dao.RobotDao;
import spring.lesson16.entity.Robot;

import java.util.List;


/*Repository - бозначаате клас как источник данных
* Transactional - позводяет работаться с данными в упрощенной форме*/
@Repository
@Transactional
public class RobotDaoImpl implements RobotDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(Robot robot) {
        return (Long) factory
                .getCurrentSession()
                .save(robot);
    }

    @Override
    public Robot read(Long id) {
        return factory
                .getCurrentSession().get(Robot.class, id);
    }

    @Override
    public boolean update(Robot robot) {
        factory
                .getCurrentSession()
                .saveOrUpdate(robot);
        return true;
    }

    @Override
    public boolean delete(Robot robot) {
        factory
                .getCurrentSession()
                .delete(robot);
        return true;
    }

    @Override
    public List<Robot> findAll() {
        return factory
                .getCurrentSession().createCriteria(Robot.class)
                .list();
    }
}
