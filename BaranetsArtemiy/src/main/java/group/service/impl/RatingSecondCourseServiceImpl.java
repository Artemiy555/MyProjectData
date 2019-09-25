package group.service.impl;

import group.dao.RatingSecondCourseDao;
import group.dao.impl.RatingSecondCourseDAOImpl;
import group.entily.RatingSecondCourse;
import group.entily.Student;
import group.service.RatingSecondCourseService;

public class RatingSecondCourseServiceImpl implements RatingSecondCourseService {

    private RatingSecondCourseDao ratingSecondCourseDao;

    public RatingSecondCourseServiceImpl() {
        ratingSecondCourseDao = new RatingSecondCourseDAOImpl();
    }

    @Override
    public RatingSecondCourse create(
            Student student, String math, String prog) {
        if (student != null) {
            RatingSecondCourse ratingSecondCourse = new RatingSecondCourse(math,prog,student);
            ratingSecondCourse.setMidRating(ratingSecondCourseDao.create(ratingSecondCourse));
            return ratingSecondCourse;
        }
        return null;
    }


}
