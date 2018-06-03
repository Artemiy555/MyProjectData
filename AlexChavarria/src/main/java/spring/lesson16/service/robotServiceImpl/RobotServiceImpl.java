package spring.lesson16.service.robotServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lesson16.dao.RobotDao;
import spring.lesson16.entity.Robot;
import spring.lesson16.service.RobotService;

import java.util.Date;
import java.util.List;

@Service
public class RobotServiceImpl implements RobotService {

    @Autowired
    private RobotDao dao;

    @Override
    public Robot create(String model, Date creationDate, Double price) {
        Robot robot = new Robot(model,creationDate,price);
        robot.setId(dao.create(robot));
        return robot;
    }

    @Override
    public Robot findById(Long id) {
        if (id != null){
            return dao.read(id);
        }
        return null;
    }

    @Override
    public void update(Robot robot) {
        if (dao.update(robot)){
            System.out.println("update success");
            return;
        }
        System.out.println("update fail");
    }

    @Override
    public void delete(Robot robot) {
        if (dao.delete(robot)){
            System.out.println("delete success");
            return;
        }
        System.out.println("delete fail");
    }

    @Override
    public List<Robot> findAll() {
        return dao.findAll();
    }
}
