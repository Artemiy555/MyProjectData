package hibernate.lesson14.service.impl;

import hibernate.lesson14.dao.CroupDao;
import hibernate.lesson14.entity.Course;
import hibernate.lesson14.entity.Croup;
import hibernate.lesson14.service.CroupService;

import java.security.acl.Group;
import java.util.Date;

public class CroupServiceImpl implements CroupService {
    private CroupDao croupDao;

    public CroupServiceImpl(CroupDao croupDao) {
        this.croupDao = croupDao;
    }

    public CroupServiceImpl() {

    }

    @Override
    public Croup create(Course course, String title, Date begin, Date end) {
        if (course != null) {
            Croup croup = new Croup(course, title, begin, end);
            croup.setId(croupDao.create(croup));
            return croup;
        }
        return null;
    }
}
