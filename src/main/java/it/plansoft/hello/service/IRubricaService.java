package it.plansoft.hello.service;

import it.plansoft.hello.dto.RubricaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
public interface IRubricaService {

    List<RubricaDto> findBySearch(String name, String surname, String address);

    RubricaDto findById(Long id);

    RubricaDto save(RubricaDto dto);

    RubricaDto update(Long id, RubricaDto dto);

    RubricaDto delete(Long id);

    Page<RubricaDto> findAll(Pageable pageable);
}
