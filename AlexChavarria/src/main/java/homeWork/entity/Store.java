package homeWork.entity;


import homeWork.entity.subEntity.Vendor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Склад")
public class Store {
    @Id
    @Column(name = "PARTY_ROOM_ID")
    @SequenceGenerator(name = "partyRoomId",
                    sequenceName = "SEQ_PARTY_ROOM_ID",
                    initialValue = 4000,
                    allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "partyRoomId")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date receivingDate;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "partyRoomId",
            cascade = { CascadeType.REMOVE},
            targetEntity = Vendor.class
    )
    private List<NoteBook> noteBookList = new ArrayList<>();

    private Integer quantityInStock;

    public Store(Date receivingDate, List<NoteBook> noteBookList, Integer quantityInStock) {
        this.receivingDate = receivingDate;
        this.noteBookList = noteBookList;
        this.quantityInStock = quantityInStock;
    }
    public Store() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getReceivingDate() {
        return receivingDate;
    }
    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }
    public List<NoteBook> getNoteBookList() {
        return noteBookList;
    }
    public void setNoteBookList(List<NoteBook> noteBookList) {
        this.noteBookList = noteBookList;
    }
    public Integer getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", receivingDate=" + receivingDate +
                ", noteBookList=" + noteBookList +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
