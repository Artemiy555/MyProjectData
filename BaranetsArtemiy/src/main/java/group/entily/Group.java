package group.entily;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "GROUPS")
public class Group {

    @Id
    @Column(name = "GROUP_ID")
    @SequenceGenerator(
            name = "groupId",
            sequenceName = "SEQ_GROUP_ID",
            initialValue = 2018_00000,
            allocationSize = 25
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "groupId"
    )
    private Long id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = Course.class
    )
    @JoinColumn(
            name = "COURSE_ID",
            nullable = false
    )
    private Course courseId;

    @Column
    private String title;

    @Temporal(TemporalType.DATE)
    private Date begin;

    @Temporal(TemporalType.DATE)
    private Date end;


    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "groupId",
            cascade = CascadeType.REMOVE,
            targetEntity = Student.class
    )
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    @Override
    public String toString() {
        return
                 courseId.getId().toString();

    }

    public Group() {}
    public Group(Course courseId, String title, Date begin, Date end) {
        this.courseId = courseId;
        this.title = title;
        this.begin = begin;
        this.end = end;
    }

    public Group(Long id, Date begin, Date end, String title) {
        this.id = id;
        this.title = title;
        this.begin = begin;
        this.end = end;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Course getCourseId() {
        return courseId;
    }
    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getBegin() {
        return begin;
    }
    public void setBegin(Date begin) {
        this.begin = begin;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }


}
