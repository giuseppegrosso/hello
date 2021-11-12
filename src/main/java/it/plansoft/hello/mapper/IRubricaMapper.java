package it.plansoft.hello.mapper;

import it.plansoft.hello.dto.RubricaDto;
import it.plansoft.hello.model.Rubrica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
@Mapper(componentModel = "spring")
public interface IRubricaMapper extends IMapper<RubricaDto, Rubrica>
{

    IRubricaMapper INSTANCE = Mappers.getMapper(IRubricaMapper.class);

}
