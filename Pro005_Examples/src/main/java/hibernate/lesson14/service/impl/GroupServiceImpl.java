package hibernate.lesson14.service.impl;

import hibernate.lesson14.dao.GroupDAO;
import hibernate.lesson14.dao.impl.GroupDAOImpl;
import hibernate.lesson14.entity.Course;
import hibernate.lesson14.entity.Group;

import java.util.Date;

public class GroupServiceImpl implements GroupService {

    private GroupDAO groupDAO;

    public GroupServiceImpl() {
        groupDAO = new GroupDAOImpl();
    }

    @Override
    public Group create(
            Course course, String title, Date begin, Date end) {
        if (course != null) {
            Group group = new Group(course, title, begin, end);
            group.setId(groupDAO.create(group));
            return group;
        }
        return null;
    }
}
