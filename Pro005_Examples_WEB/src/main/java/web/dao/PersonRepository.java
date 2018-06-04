package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.domain.Person;

public interface PersonRepository
        extends JpaRepository<Person, Long> {
}
