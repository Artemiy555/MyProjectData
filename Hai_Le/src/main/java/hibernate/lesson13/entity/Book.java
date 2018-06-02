package hibernate.lesson13.entity;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @Column(name ="BOOK_ID")
    //Позволяет собственноручно задавать правила
    @SequenceGenerator(
            name = "bookId",
            sequenceName = "SEQ_BOOK_ID",
            initialValue = 100_000,
            allocationSize = 25
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bookId"
    )
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR_ID",
            nullable = false)
    private Author author;

    public Book() {};

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
