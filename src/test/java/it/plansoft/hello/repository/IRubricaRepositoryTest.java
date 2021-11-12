package it.plansoft.hello.repository;

import it.plansoft.hello.model.Rubrica;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    }


    @Test
    public void itShouldFindBySurnameShouldOk()
    {
        List<Rubrica> rubricaList = this.repo.findBySurname("Grosso");

        assertTrue(rubricaList.size() > 0);

    }

    @Test
    void itShouldSelectIfExistsSurname()
    {
        String surname = "Grosso";
        // fornire dato
        Rubrica rubrica = new Rubrica("Grosso", "Giuseppe",
                "via delle fonti 11");
        // quando
        this.repo.save(rubrica);
        boolean exists = this.repo.selectExistsSurname(surname);

        // dopo
        assertTrue(exists);

    }

    protected void loadDataBase() {
        this.repo.save(new Rubrica("Grosso", "Giuseppe",
               "via delle fonti 11"));

    }
}