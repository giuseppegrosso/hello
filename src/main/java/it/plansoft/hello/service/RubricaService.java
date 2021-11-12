package it.plansoft.hello.service;

import it.plansoft.hello.dto.RubricaDto;
import it.plansoft.hello.mapper.IRubricaMapper;
import it.plansoft.hello.model.Rubrica;
import it.plansoft.hello.repository.IRubricaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
@Service
public class RubricaService implements IRubricaService {
    // iniettare il repository per l'accesso al dato.

    private IRubricaRepository repository;
    private static IRubricaMapper mapper;

    // DI --> inietto a runtime
    public RubricaService(IRubricaRepository rubricaRepository) {
        this.repository = rubricaRepository;
        this.mapper = IRubricaMapper.INSTANCE;
    }

    @Override
    public List<RubricaDto> findBySearch(String name, String surname, String address) {
        System.out.println(String.format("findBySearch %s %s %s", name, surname, address));
        List<Rubrica> list =  this.repository.findBySurname(surname);
        // conversione in dto
        return mapper.toDtos(list);

    }

    @Override
    public RubricaDto findById(Long id) {
        System.out.println(String.format("find %s", id));
        Optional<Rubrica> byId = this.repository.findById(id);
        return mapper.toDto(byId.isPresent() ? byId.get() : new Rubrica());
    }

    @Override
    public RubricaDto save(RubricaDto dto) {
        System.out.println(String.format("save"));
        Rubrica save = this.repository.save(mapper.dtoToModel(dto));
        return mapper.toDto(save);
    }

    @Override
    public RubricaDto update(Long id, RubricaDto dto) {

        Optional<Rubrica> byId = this.repository.findById(id);
        // aggiorno le properties
        if (byId.isPresent())
        {
            byId.get().setAddress(dto.getAddress());
            byId.get().setSurname(dto.getSurname());
            byId.get().setName(dto.getName());
            this.repository.save(byId.get());
        }

        return mapper.toDto(byId.get());
    }

    @Override
    public RubricaDto delete(Long id) {
        System.out.println(String.format("delete %s", id));
        Optional<Rubrica> byId = this.repository.findById(id);

        this.repository.deleteById(id);

        if (byId.isPresent())
            return mapper.toDto(byId.get());

        return null;
    }
}
