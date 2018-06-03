package spring.lesson16.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ROBOTS")

public class Robot {
    @Id
    @Column(name = "ROBOT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String model;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column
    private Double price;

    public Robot() { }
    public Robot(String model, Date creationDate, Double price) {
        this.model = model;
        this.creationDate = creationDate;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", creationDate=" + creationDate +
                ", price=" + price +
                '}';
    }
}
