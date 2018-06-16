package hibernate.lesson14.service;


import hibernate.lesson14.entity.Course;
import hibernate.lesson14.entity.Croup;

import java.security.acl.Group;
import java.util.Date;

public interface CroupService {
    Croup create(
            Course course, String title, Date begin, Date end);
}
