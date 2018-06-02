package homeWork.entity.subEntity;


import homeWork.entity.NoteBook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Продавец")
public class Vendor {
    @Id
    @Column(name = "VENDOR_ID")
    @SequenceGenerator(
            name = "vendorId",
            sequenceName = "SEQ_VENDOR_ID",
            initialValue = 5000,
            allocationSize = 10
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "vendorId")
    private Long id;

   @Column
    private String name;
   @Column
    private String description;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = NoteBook.class
    )
    @JoinColumn(name = "NOTEBOOK_ID",
            nullable = false)
    private NoteBook noteBookId;

    public Vendor() {
    }
    public Vendor(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public NoteBook getNoteBookId() {
        return noteBookId;
    }
    public void setNoteBookId(NoteBook noteBookId) {
        this.noteBookId = noteBookId;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", noteBookId=" + noteBookId +
                '}';
    }
}
