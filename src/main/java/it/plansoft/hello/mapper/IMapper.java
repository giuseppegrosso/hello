package it.plansoft.hello.mapper;

import it.plansoft.hello.model.Rubrica;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
public interface IMapper<DTO, MODEL> {

    DTO toDto(MODEL model);
    MODEL dtoToModel(DTO dto);
    List<DTO> toDtos(List<MODEL> models);
    List<MODEL> toModels(List<DTO> dtos);
    // set
    Set<DTO> toSetDtos(Set<MODEL> model);

    //Page<DTO> toPagebleDtos(Page<MODEL> models);
    // ... aggiungere eventuali altre collection
}