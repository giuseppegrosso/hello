package it.plansoft.hello.repository;

import it.plansoft.hello.model.Rubrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
@Repository
public interface IRubricaRepository extends JpaRepository<Rubrica, Long> {

    // ricerca della rubrica dato il cognome
    List<Rubrica> findBySurname(String surname);

    @Query("SELECT CASE WHEN COUNT(r) > 0 then TRUE ELSE FALSE END " +
            "FROM Rubrica r WHERE r.surname = ?1")
    Boolean selectExistsSurname(String surname);

    // ricerca della rubrica dato il cognome
    List<Rubrica> findByName(String name);
}
