package group.entily;

import javax.persistence.*;

@Entity
@Table(name = "SECOND_FIRST_COURSE")
public class RatingSecondCourse {

    @Id
    @Column(name = "MID_RATING")
    @SequenceGenerator(
            name = "mid_rating",
            sequenceName = "SEQ_MID_RATING",
            initialValue = 2018_00000,
            allocationSize = 25
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mid_rating"
    )
    private long midRating;

    @Column
    private String ratingMach;

    @Column
    private String ratingProg;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = Student.class
    )
    @JoinColumn(
            name = "STUDENT_ID",
            nullable = false
    )
    private Student studentID;


    public long getMidRating() {
        return midRating;
    }

    public void setMidRating(long midRating) {
        this.midRating = midRating;
    }

    public String getRatingMach() {
        return ratingMach;
    }

    public void setRatingMach(String ratingMach) {
        this.ratingMach = ratingMach;
    }

    public String getRatingProg() {
        return ratingProg;
    }

    public void setRatingProg(String ratingProg) {
        this.ratingProg = ratingProg;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    public RatingSecondCourse(String ratingMach, String ratingProg, Student studentID) {
        this.ratingMach = ratingMach;
        this.ratingProg = ratingProg;
        this.studentID = studentID;
    }

    public RatingSecondCourse(String ratingMach, String ratingProg,Integer midRating) {
        this.ratingMach = ratingMach;
        this.ratingProg = ratingProg;
        this.midRating = midRating;


    }

    @Override
    public String toString() {
        return "RatingSecondCourse{" +
                "midRating=" + midRating +
                ", ratingMach='" + ratingMach + '\'' +
                ", ratingProg='" + ratingProg + '\'' +
                ", studentID=" + studentID +
                '}';
    }
}
