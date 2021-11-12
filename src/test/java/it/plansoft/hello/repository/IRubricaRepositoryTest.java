package it.plansoft.hello.repository;

import it.plansoft.hello.model.Rubrica;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
@SpringBootTest
@Slf4j
class IRubricaRepositoryTest {

    @Autowired
    IRubricaRepository repo;


    @BeforeEach
    public void startup() {
        log.info("startup");
        loadDataBase();
    }

    @AfterEach
    public void shutdown() {
        log.info("shutdown");
        this.repo.deleteAll();
    }


    @Test
    public void itShouldFindBySurnameShouldOk()
    {
        List<Rubrica> rubricaList = this.repo.findBySurname("Grosso");

        assertTrue(rubricaList.size() > 0);

        Rubrica rubrica = rubricaList.get(0);

        assertTrue(rubrica.getSurname().equals("Grosso"));

    }

    @Test
    void itShouldSelectIfExistsSurname()
    {
        String surname = "Grosso";
        // cerac del dato
        boolean exists = this.repo.selectExistsSurname(surname);

        // dopo
        assertTrue(exists);

    }

    protected void loadDataBase() {
        this.repo.save(new Rubrica("Grosso", "Giuseppe",
               "via delle fonti 11"));

    }
}