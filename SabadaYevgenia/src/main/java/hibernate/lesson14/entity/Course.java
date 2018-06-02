package hibernate.lesson14.entity;


import javafx.scene.Group;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSES")
public class Course implements Serializable {
    @Id
    @Column(name = "COURSES_ID")
    @SequenceGenerator(
            name = "courseId",
            sequenceName = "SEQ_COURSE_ID",
            initialValue = 10000,
            allocationSize = 50
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseId"
    )
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "courseId",
            targetEntity = Group.class
    )
    private List<Croup>groups = new ArrayList<>();

    public Course(String title, String description, List<Croup> groups) {
        this.title = title;
        this.description = description;
        this.groups = groups;
    }

    public Course() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<Croup> getGroups() { return groups; }
    public void setGroups(List<Croup> groups) { this.groups = groups; }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", groups=" + groups +
                '}';
    }
}