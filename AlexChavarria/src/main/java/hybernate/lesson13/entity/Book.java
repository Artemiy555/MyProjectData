package hybernate.lesson13.entity;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")


public class Book {

    @Id
    @Column(name = "BOOK_ID")
    @SequenceGenerator(
            name = "bookId",
            sequenceName = "SEQ_BOOKS_ID",
            initialValue = 100_000,
            allocationSize = 25
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "bookId")
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR_ID",
                //referencedColumnName = "id",
                nullable = false)
    private Author author;

    public Book() {
    }
    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
}
