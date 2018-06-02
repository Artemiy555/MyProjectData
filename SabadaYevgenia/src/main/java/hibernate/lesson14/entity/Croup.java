package hibernate.lesson14.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CROUP")
public class Croup {

    @Id
    @Column(name = "GROUP_ID")
    @SequenceGenerator(
            name = "groupId",
            sequenceName = "SEQ_GROUP_ID",
            initialValue = 201800000,
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
    private Date and;

    public Croup(Course courseId, String title, Date begin, Date and) {
        this.courseId = courseId;
        this.title = title;
        this.begin = begin;
        this.and = and;
    }

    public Croup() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Course getCourseId() { return courseId; }
    public void setCourseId(Course courseId) { this.courseId = courseId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Date getBegin() { return begin; }
    public void setBegin(Date begin) { this.begin = begin; }
    public Date getAnd() { return and; }
    public void setAnd(Date and) { this.and = and; }

    @Override
    public String toString() {
        return "Croup{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", title='" + title + '\'' +
                ", begin=" + begin +
                ", and=" + and +
                '}';
    }
}
