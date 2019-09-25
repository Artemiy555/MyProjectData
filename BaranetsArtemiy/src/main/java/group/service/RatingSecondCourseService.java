package group.service;

import group.entily.RatingSecondCourse;
import group.entily.Student;

public interface RatingSecondCourseService {


    RatingSecondCourse create(
            Student student, String math, String prog);

}
