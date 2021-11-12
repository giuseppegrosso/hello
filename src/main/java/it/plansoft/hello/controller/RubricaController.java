package it.plansoft.hello.controller;

import it.plansoft.hello.dto.RubricaDto;
import it.plansoft.hello.service.RubricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
@RestController
@RequestMapping("/rubrica")
public class RubricaController implements IRubricaController {

    // service .... che contiene la logica.
    // DI attenzione si può fare con @Autowired
    private RubricaService rubricaService;

    // DI 2 caso: senza @Autowired + costruttore con service.
    public RubricaController(RubricaService rubricaService) {
        this.rubricaService = rubricaService;
    }

    @GetMapping("/findBySearch")
    @Override
    public List<RubricaDto> findBySearch(@RequestParam Optional<String> name,
                                         @RequestParam Optional<String> surname,
                                         @RequestParam Optional<String> address) {
        return rubricaService.findBySearch(name.isPresent() ? name.get() : "", surname.isPresent() ? surname.get() : "", address.isPresent() ? address.get() : "");
    }

    @Override
    @GetMapping("/findById/{id}")
    public RubricaDto findById(@PathVariable Long id) {
        return rubricaService.findById(id);
    }

    @Override
    @PostMapping("/save")
    public RubricaDto save(@RequestBody RubricaDto dto) {
        return rubricaService.save(dto);
    }

    @Override
    @PutMapping("/update/{id}")
    public RubricaDto update(@PathVariable Long id, @RequestBody RubricaDto dto) {
        return rubricaService.update(id, dto);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public RubricaDto delete(@PathVariable Long id) {
        return rubricaService.delete(id);
    }

    // aggiungere altre api per casi specifici

}
