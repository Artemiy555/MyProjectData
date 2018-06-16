package spring.lesson16.service;

import spring.lesson16.entity.Robot;

import java.util.Date;
import java.util.List;

public interface RobotService {
    Robot create(String model, Date creationDate,Double price);
    Robot findById(Long id);
    void update(Robot robot);
    void delete(Robot robot);
    List<Robot> finfAll();
}
