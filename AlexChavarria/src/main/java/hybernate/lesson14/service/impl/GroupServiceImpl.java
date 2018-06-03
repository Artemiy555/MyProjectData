package hybernate.lesson14.service.impl;



import hybernate.lesson14.dao.GroupDAO;
import hybernate.lesson14.dao.impl.GroupDAOImpl;
import hybernate.lesson14.entity.Course;
import hybernate.lesson14.entity.Group;

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
