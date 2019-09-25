package group.service.impl;

import group.dao.RatingFirstCourseDao;
import group.dao.impl.RatingFirstCourseDAOImpl;
import group.entily.RatingFirstCourse;
import group.entily.Student;
import group.service.RatingFirstCourseService;


public class RatingFirstCourseServiceImpl implements RatingFirstCourseService {

    private RatingFirstCourseDao ratingFirstCourseDao;

    public RatingFirstCourseServiceImpl() {
        ratingFirstCourseDao = new RatingFirstCourseDAOImpl();
    }

    @Override
    public RatingFirstCourse create(
            Student student, String math, String prog) {
        if (student != null) {
            RatingFirstCourse ratingSecondCourse = new RatingFirstCourse(math,prog,student);
            ratingSecondCourse.setMidRating(ratingFirstCourseDao.create(ratingSecondCourse));
            return ratingSecondCourse;
        }
        return null;
    }

}
