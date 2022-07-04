package com.github.annasperendio.states.contoller;

import com.github.annasperendio.states.models.entity.States;
import com.github.annasperendio.states.models.entity.StatesDto;
import com.github.annasperendio.states.models.entity.repository.StatesRepository;
import com.github.annasperendio.states.service.StatesService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StatesController {

    private org.slf4j.Logger log = (org.slf4j.Logger) LoggerFactory.getLogger(StatesController.class);

    @Autowired
    private StatesService service;
    @Autowired
    private StatesRepository StatesRepository;


    //Os métodos:

    @PostMapping
    public ResponseEntity<StatesDto> createNewStates(@RequestBody StatesDto states) {
        log.info("CreateNewStates() - INICIO - Chamando Serviço");
        StatesDto statesDto = service.addNewStates(states);
        return ResponseEntity.ok(statesDto);
    }

    @GetMapping
    public ResponseEntity<List<StatesDto>> getAllStates() {
        return ResponseEntity.ok(service.getAllStates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatesDto> findStatesById(@PathVariable Long id) {
        log.info("findStatesById() - INICIO - Chamando Serviço");
        return ResponseEntity.ok(service.getStatesById(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StatesDto> updateStates(@PathVariable Long id, @RequestBody @Validated StatesDto statesDto) {
        log.info("UpdateStates() - INICIO - Chamando Serviço");
        States states = statesDto.updateStates(id, StatesRepository);
        return ResponseEntity.ok(new StatesDto(states));
    }
}
