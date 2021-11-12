package it.plansoft.hello.controller;

import it.plansoft.hello.dto.RubricaDto;

import java.util.List;
import java.util.Optional;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
public interface IRubricaController {

    // GET

    /**
     * recupero gli oggetti tramite la ricerca per nome, cognome, indirizzo
     * @param name
     * @param surname
     * @param address
     * @return lista che soddisfa le condizioni impostate.
     */
    List<RubricaDto> findBySearch(Optional<String> name, Optional<String> surname, Optional<String> address);

    /**
     * ricerca tramite chiave.
     * @param id
     * @return
     */
    RubricaDto findById(Long id);

    RubricaDto save(RubricaDto dto);

    RubricaDto update(Long id, RubricaDto dto);

    RubricaDto delete(Long id);

}
