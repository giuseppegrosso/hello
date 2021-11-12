package it.plansoft.hello.mapper;

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
    // ... aggiungere eventuali altre collection
}