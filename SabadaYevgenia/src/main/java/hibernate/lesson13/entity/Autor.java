package hibernate.lesson13.entity;

import javax.persistence.*;

@Entity
@Table(name="AUTHORS")
public class Autor {

    @Id
    @Column(name="AUTOR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String surname;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "autor")
    private Book book;

    public Autor() { }
    public Autor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
