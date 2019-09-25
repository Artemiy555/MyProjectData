package group.entily;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    @SequenceGenerator(
            name = "studentId",
            sequenceName = "SEQ_STUDENT_ID",
            initialValue = 2018_00000,
            allocationSize = 25
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "studentId"
    )
    private Long idRating;


    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = Group.class
    )
    @JoinColumn(
            name = "GROUP_ID",
            nullable = false
    )
    private Group groupId;


    @Column
    private String fullName;


//    @OneToMany(
//            fetch = FetchType.EAGER,
//            mappedBy = "studentId",
//            cascade = CascadeType.REMOVE,
//            targetEntity = RatingFirstCourse.class
//    )
//    private List<RatingFirstCourse> ratingFirstCourses = new ArrayList<>();
//
//    public List<RatingFirstCourse> getRatingFirstCourses() {
//        return ratingFirstCourses;
//    }
//
//    public void setRatingFirstCourses(List<RatingFirstCourse> ratingFirstCourses) {
//        this.ratingFirstCourses = ratingFirstCourses;
//    }


    public Student() {
    }

    public Student(Group groupId, String fullName) {
        this.groupId = groupId;
        this.fullName = fullName;
    }





//    @OneToMany(
//            fetch = FetchType.EAGER,
//            mappedBy = "studentId",
//            cascade = CascadeType.REMOVE,
//            targetEntity = RatingSecondCourse.class
//    )
//    private List<RatingSecondCourse> ratingSecondCourses = new ArrayList<>();
//
//    public List<RatingSecondCourse> getRatingSecondCourses() {
//        return ratingSecondCourses;
//    }
//
//    public void setRatingSecondCourses(List<RatingSecondCourse> ratingSecondCourses) {
//        this.ratingSecondCourses = ratingSecondCourses;
//    }




    public Long getIdRating() {
        return idRating;
    }

    public void setIdRating(Long idRating) {
        this.idRating = idRating;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idRating=" + idRating +
                ", groupId=" + groupId +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
