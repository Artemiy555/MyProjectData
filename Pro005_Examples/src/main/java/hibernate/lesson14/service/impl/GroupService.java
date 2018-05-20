package hibernate.lesson14.service.impl;

import hibernate.lesson14.entity.Course;
import hibernate.lesson14.entity.Group;

import java.util.Date;

public interface GroupService {

    Group create(
            Course course, String title, Date begin, Date end);
}
