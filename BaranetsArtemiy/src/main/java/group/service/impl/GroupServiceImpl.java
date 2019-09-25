package group.service.impl;



import group.dao.impl.GroupDAOImpl;
import group.entily.Course;
import group.entily.Group;
import group.service.GroupService;
import group.dao.GroupDao;

import java.util.Date;

public class GroupServiceImpl implements GroupService{

    private GroupDao groupDAO;

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
