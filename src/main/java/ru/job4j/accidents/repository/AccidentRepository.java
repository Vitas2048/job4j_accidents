package ru.job4j.accidents.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.accidents.model.Accident;

import java.util.List;
import java.util.Optional;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @Query("""
            from Accident a
            left join fetch a.rules
            left join fetch a.type
            """)
    List<Accident> findAll();

    @Query("""
            from Accident a
            left join fetch a.rules
            left join fetch a.type
            where a.id=:fId
            """)
    Optional<Accident> findById(@Param("fId") int id);
}