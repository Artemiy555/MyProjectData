package hibernate.lesson13.entity;

import javax.persistence.*;

//Класс-сущность
@Entity
@Table(name= "AUTHORS")
public class Author {

    //Обязательно глянуть!
    @Id
    @Column(name="AUTHOR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "author")
    private Book book;

    public Author() {}

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
