package group.dao;

import group.entily.RatingSecondCourse;

import java.util.List;

public interface RatingSecondCourseDao {

    Long create(RatingSecondCourse ratingSecondCourse);

    RatingSecondCourse read(Long id);

    boolean update(RatingSecondCourse ratingSecondCourse);

    boolean delete(Long id);

    List<RatingSecondCourse> findAll();


}
