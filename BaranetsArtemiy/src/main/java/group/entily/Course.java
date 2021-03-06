package group.entily;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name = "COURSES")
    public class Course {

        @Id
        @Column(name = "COURSE_ID")
        @SequenceGenerator(
                name = "courseId",
                sequenceName = "SEQ_COURSE_ID",
                initialValue = 100_000,
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
                cascade = CascadeType.REMOVE,
                targetEntity = Group.class
        )
        private List<Group> groups = new ArrayList<>();

        public Course() {
        }

        public Course(Long id,String title, String description) {
            this.id = id;
            this.title = title;
            this.description = description;
        }

        public Course(String title, String description) {
            this.title = title;
            this.description = description;
        }

//
        @Override
        public String toString() {
            return
                    id.toString();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Group> getGroups() {
            return groups;
        }

        public void setGroups(List<Group> groups) {
            this.groups = groups;
        }



    }


