package homeWork.entity;

import homeWork.entity.subEntity.Cpu;
import homeWork.entity.subEntity.Memory;
import homeWork.entity.subEntity.Vendor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "НоутБук")
public class NoteBook {
    @Id
    @Column(name = "NOTEBOOK_ID")
    @SequenceGenerator(
            name = "noteBookId",
            sequenceName = "SEQ_NOTE_BOOK_ID",
            initialValue = 3_000,
            allocationSize = 10
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "noteBookId"
    )
    private Long id;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "noteBookId",
            cascade = { CascadeType.REMOVE},
            targetEntity = Cpu.class
    )
    private List<Cpu> cpuList = new ArrayList<>();

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "noteBookId",
            cascade = { CascadeType.REMOVE},
            targetEntity = Vendor.class
    )
    private List<Vendor> vendorList = new ArrayList<>();

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "noteBookId",
            cascade = { CascadeType.REMOVE},
            targetEntity = Memory.class
    )
    private List<Memory> memoryList = new ArrayList<>();


    public int getPartyRoomId() {
        return partyRoomId;
    }
    public void setPartyRoomId(int partyRoomId) {
        this.partyRoomId = partyRoomId;
    }

    private int partyRoomId;

    private Double  price;

    @Temporal(TemporalType.DATE)
    private Date manufactureDate;

    public NoteBook() {
    }

    public NoteBook(List<Cpu> cpuList, List<Memory> memoryList, List<Vendor> vendorList,
                    Double price, Date manufactureDate) {
        this.cpuList = cpuList;
        this.memoryList = memoryList;
        this.vendorList = vendorList;
        this.price = price;
        this.manufactureDate = manufactureDate;
    }

    public NoteBook(List<Cpu> cpuList, List<Vendor> vendorList, List<Memory> memoryList, int partyRoomId, Double price) {
        this.cpuList = cpuList;
        this.vendorList = vendorList;
        this.memoryList = memoryList;
        this.partyRoomId = partyRoomId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Cpu> getCpuList() {
        return cpuList;
    }
    public void setCpuList(List<Cpu> cpuList) {
        this.cpuList = cpuList;
    }
    public List<Memory> getMemoryList() {
        return memoryList;
    }
    public void setMemoryList(List<Memory> memoryList) {
        this.memoryList = memoryList;
    }
    public List<Vendor> getVendorList() {
        return vendorList;
    }
    public void setVendorList(List<Vendor> vendorList) {
        this.vendorList = vendorList;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Date getManufactureDate() {
        return manufactureDate;
    }
    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "id=" + id +
                ", cpuList=" + cpuList +
                ", memoryList=" + memoryList +
                ", vendorList=" + vendorList +
                ", price=" + price +
                ", manufactureDate=" + manufactureDate +
                '}';
    }
}
