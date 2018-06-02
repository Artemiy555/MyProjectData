package hibernate.lesson13.dao;


import hibernate.lesson13.entity.Autor;

import java.util.List;

/*Data Access Object (DAO)- основная функция которого обеспечение
доступа к хранилищщу данных и хранимых в ним данных

Минимум 5 операций
CRUD-операции
-Create -зодание
-Read
-Update
-Delete

findAll - получение всех записей которые имеються
в таблице

getAll - */
public interface AuthorDao {
    /*Create(создание):
    *-ID-если создаем записи прошлого успешно, то делаем пользователю ID-заиси
     * -Boolean-если запись создана tru, иначе fals
      * -Void-без возврата результата */
    Long create(Autor autor);
    Autor read (Long id);
    boolean updete(Autor autor);
    boolean delete(Autor autor);
    /**FinAll*/
    List<Autor> finAll();


}
