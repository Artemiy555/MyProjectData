package hybernate.lesson14.service.impl;



import hybernate.lesson14.entity.Course;
import hybernate.lesson14.entity.Group;

import java.util.Date;

public interface GroupService {

    Group create(
            Course course, String title, Date begin, Date end);
}
