package spring.lesson16Homework.entity;


import javax.persistence.*;

@Entity
@Table(name = "CLIENT")

public class Client {
    @Id
    @Column(name ="CLIENT_ID" )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String fullName;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String discount;

    public Client() { }

    public Client(String fullName, String phone, String email, String discount) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.discount = discount;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone;}
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDiscount() { return discount; }
    public void setDiscount(String discount) { this.discount = discount; }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }
}
