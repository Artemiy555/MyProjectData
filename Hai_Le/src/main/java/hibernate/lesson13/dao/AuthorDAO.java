package hibernate.lesson13.dao;

/*
    Data Access Object DAO - основная функция которого обоспечение
    доступа к хранилищу данных и хранимых в нем записей

    Минимум 5 операций, так называемые CRUD-операции:
    -Create     - создание записи
    -Read       - чтение записи
    -Update     - обновление записи
    -Delete     - удаление записи

    -findAll     - получение(поиск) всех записей
                  которые имеются в таблице

    -getAll      - *получение всех записей
                  которые имеются в таблице,
                  без подразумевания того,
                  что таблица пустая
 */

import hibernate.lesson13.entity.Author;

import java.util.List;

public interface AuthorDAO {
    /*
        Create

        Тип возвращаемого значения:
         - ID       - если создание записи прошло успешно, то отдаем
                      пользователю ID-записи
         - Boolean  - если запись создана true, иначе false
         - Void     - без возращения значений

     */
    Long create(Author author);

    /* Read */
    Author read(long id);

    /*
        Update
        -true если обновлена
        -false если не обновлена

        Передаем в качестве параметра
        целевой обьект(Author) либо ID-запись
      */
    boolean update(Author author);
    /*
        Delete
        -true если запись удалена
        -false если не удалена

        Передаем в качестве параметра
        целевой обьект(Author) либо ID-запись
     */
    boolean delete(Author author);

    /* findAll */
    List<Author> findAll();
}
