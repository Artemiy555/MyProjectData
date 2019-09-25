package group.dao;

import group.entily.RatingFirstCourse;

import java.util.List;

public interface RatingFirstCourseDao {

    Long create(RatingFirstCourse ratingFirstCourse);

    RatingFirstCourse read(Long id);

    boolean update(RatingFirstCourse ratingFirstCourse);

    boolean delete(Long id);

    List<RatingFirstCourse> findAll();


}
