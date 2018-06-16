//package hibernate.lesson13;
//
//import hibernate.lesson13.dao.AuthorDao;
//import hibernate.lesson13.dao.BookDao;
//import hibernate.lesson13.dao.impl.AutorDAOImpl;
//import hibernate.lesson13.dao.impl.BookDAOImpl;
//import hibernate.lesson13.entity.Autor;
//import hibernate.lesson13.entity.Book;
//import hibernate.lesson13.util.HibernateUtil;
//
//import java.util.List;
//
//public class DaoTest {
//    public static void main(String[] args) {
//
//        Autor autor1=new Autor("Irvin","Show");
//        Autor autor2=new Autor("Alexandr","Sokolov");
//        Book book = new Book("Prectuplenee","Nakazaune");
//        Book book1 = new Book("Vona", "Mir");
//
//        AuthorDao authorDao=new AutorDAOImpl();
//
//        System.out.println("Test creat()");
//        System.out.println(authorDao.create(autor1));
//        System.out.println(authorDao.create(autor2));
//
//        System.out.println("Test findAll()");
//        List<Autor> autors=authorDao.finAll();
//        for(Autor autor:autors){
//            System.out.println(autor);
//        }
//
//        System.out.println("Test read()");
//        System.out.println(authorDao.read(1L));
//
//        System.out.println("Test update()");
//        Autor author3 = authorDao.read(2L);
//        author3.setName("Anna");
//        author3.setSurname("Ahmatova");
//        System.out.println(authorDao.updete(author3));
//
//        System.out.println("Test delete()");
//        authorDao.delete(author3);
//        autors = authorDao.finAll();
//        for (Autor author : autors) {
//            System.out.println(author);
//        }
//
//        BookDao bookDao=new BookDAOImpl();
//
//        System.out.println("Test creat()");
//        System.out.println(bookDao.create(book));
//        System.out.println(bookDao.create(book1));
//
//        System.out.println("Test findAll()");
//        List<Book> books=bookDao.finAll();
//        for(Book book:books){
//            System.out.println(book);
//        }
//
//
//        System.out.println("Test read()");
//        System.out.println(bookDao.read(1L));
//
//
//
//        HibernateUtil.getFactory().close();
//
//    }
//}
