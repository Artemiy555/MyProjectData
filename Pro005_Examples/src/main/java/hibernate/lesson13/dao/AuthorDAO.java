package hibernate.lesson13.dao;

/* Data Access Object (DAO) - основная функция которого
*  обеспечение доступа к хранилищу данных и хранимых в нем
*  записей
*  
*  Минимум 5 операций:
*  
*  CRUD - операции
*   - Create   - создание записи
*   - Read     - чтение записи  
*   - Update   - обновление записи
*   - Delete   - удаление записи 
*   
*  findAll - получение всех записей которые 
*            имеются в таблице           
*  getAll  */

import hibernate.lesson13.entity.Author;

import java.util.List;

public interface AuthorDAO {

    /* Create (создание):
     *
     * Тип возвращаемого значения:
     *   - ID - если создание записи прошло успешно, то отдаем
     *          пользователю ID-записи
     *   - Boolean - если запись создана true, иначе false
     *
     *   - Void     - без возврата результата */
    Long create(Author author);

    /* Read */
    Author read(Long id);

    /* Update:
     *  true - если запись обновлена
     *  false - не обновлена 
     *  
     * Передаем в качестве параметра:
     * целевой объект (Author) или ID-записи */
    boolean update(Author author);

    /* Delete:
     *  true - если запись удалена
     *  false - не удалена 
     *  
     *  Передаем в качестве параметра:
     *  целевой объект (Author) или ID-записи */
    boolean delete(Author author);
    
    /*FindAll*/
    List<Author> findAll();
}
