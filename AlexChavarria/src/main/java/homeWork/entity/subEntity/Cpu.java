package homeWork.entity.subEntity;


import homeWork.entity.NoteBook;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Процессор")
public class Cpu implements Serializable {

    @Id
    @Column(name = "Серийный номер")
    @SequenceGenerator(
            name = "cpuSerial",
            sequenceName = "SEQ_CPU_SERIAL",
            initialValue = 1,
            allocationSize = 10
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cpuSerial"
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
    private String cpuMark;
    @Column
    private String cpuFrequency;

    public Cpu() {
    }
    public Cpu(String cpuMark, String cpuFrequency) {
        this.cpuMark = cpuMark;
        this.cpuFrequency = cpuFrequency;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCpuMark() {
        return cpuMark;
    }
    public void setCpuMark(String cpuMark) {
        this.cpuMark = cpuMark;
    }
    public String getCpuFrequency() {
        return cpuFrequency;
    }
    public void setCpuFrequency(String cpuFrequency) {
        this.cpuFrequency = cpuFrequency;
    }

}
