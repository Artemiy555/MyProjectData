package group.service;

import group.entily.RatingFirstCourse;
import group.entily.Student;

public interface RatingFirstCourseService {

    RatingFirstCourse create(
            Student student, String math, String prog);


}
