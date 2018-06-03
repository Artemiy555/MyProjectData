package homeWork.entity.subEntity;

import homeWork.entity.NoteBook;

import javax.persistence.*;

@Entity
@Table(name = "Память")
public class Memory {

    @SequenceGenerator(
            name = "memoryId",
            sequenceName = "SEQ_MEMORY_ID",
            initialValue = 1_000,
            allocationSize = 10
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "memoryId"
    )
    private Long id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = NoteBook.class
    )
    @JoinColumn(name = "NOTEBOOK_ID",
            nullable = false)
    private NoteBook noteBookId;

    @Column
    private String memoryType;
    @Column
    private String memorySize;
    @Column
    private String memoryFrequency;

    public Memory() {
    }
    public Memory(String memoryType, String memorySize, String memoryFrequency) {
        this.memoryType = memoryType;
        this.memorySize = memorySize;
        this.memoryFrequency = memoryFrequency;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMemoryType() {
        return memoryType;
    }
    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }
    public String getMemorySize() {
        return memorySize;
    }
    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }
    public String getMemoryFrequency() {
        return memoryFrequency;
    }
    public void setMemoryFrequency(String memoryFrequency) {
        this.memoryFrequency = memoryFrequency;
    }


}
