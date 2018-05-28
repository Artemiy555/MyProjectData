package spring.lesson16.dao;

import spring.lesson16.entity.Robot;

import java.util.List;

public interface RobotDao {

    Long create(Robot robot);

    Robot read(Long id);

    boolean update(Robot robot);

    boolean delete(Robot robot);

    List<Robot> findAll();
}
