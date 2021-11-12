package it.plansoft.hello.service;

import it.plansoft.hello.dto.RubricaDto;
import it.plansoft.hello.mapper.IRubricaMapper;
import it.plansoft.hello.model.Rubrica;
import it.plansoft.hello.repository.IRubricaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
@SpringBootTest
@Slf4j
class RubricaServiceTest {
    @InjectMocks
    RubricaService service;

    @Mock
    IRubricaRepository repo;

    @Before
    public void startup() {
        log.info("startup");
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void shutdown() {
        log.info("shutdown");
    }


    @Test
    public void testFindBySurnameShouldOk()
    {

        List<Rubrica> list = new ArrayList<>();
        Rubrica empOne = new Rubrica(1L, "Grosso", "Giuseppe", "via xx");
        Rubrica empTwo = new Rubrica(2L, "Grosso", "Lorenzo", "via xx");
        Rubrica empThree = new Rubrica(3L, "Grosso", "Daniele", "via xx");

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        when(repo.findBySurname("Grosso")).thenReturn(list);
        //test
        List<RubricaDto> empList = this.service.findBySearch(null, "Grosso", null);

        assertEquals(3, empList.size());


    }

    @Test
    public void getRubricaByIdTest()
    {
        Rubrica r = new Rubrica(1L,"Grosso","Giuseppe","user@email.com");
        Optional<Rubrica> o = Optional.of(r);

        when(repo.findById(1L)).thenReturn(o);

        RubricaDto rubricaDto = this.service.findById(1L);

        assertEquals("Giuseppe", rubricaDto.getName());
        assertEquals("Grosso", rubricaDto.getSurname());
        assertEquals("user@email.com", rubricaDto.getAddress());
    }

}