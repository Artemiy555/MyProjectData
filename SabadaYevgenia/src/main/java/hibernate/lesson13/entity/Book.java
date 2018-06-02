package hibernate.lesson13.entity;

import javax.persistence.*;

@Entity
@Table(name="BOOKS")
public class Book {
    @Id
    @Column(name="BOOK_ID")
    @SequenceGenerator(
            name="bookId",
            sequenceName = "SEQ_BOOKS_ID",
            initialValue = 100000,
            allocationSize = 25
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bookId"
    )
    private Long id;
    @Column
    private String title;
    @Column
    private String descriptoin;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTOR_ID",
           // referencedColumnName = "id",
                    nullable = false)
    private Autor autor;


    public Book() { }
    public Book(String title, String descriptoin) {
        this.title = title;
        this.descriptoin = descriptoin;
    }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescriptoin() { return descriptoin; }
    public void setDescriptoin(String descriptoin) { this.descriptoin = descriptoin; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descriptoin='" + descriptoin + '\'' +
                '}';
    }
}
