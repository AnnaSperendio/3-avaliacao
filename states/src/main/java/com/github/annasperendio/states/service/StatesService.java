package com.github.annasperendio.states.service;

import com.github.annasperendio.states.models.entity.States;
import com.github.annasperendio.states.models.entity.StatesDto;
import com.github.annasperendio.states.models.entity.repository.StatesRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StatesService {

    private static final org.slf4j.Logger log = (org.slf4j.Logger) LoggerFactory.getLogger(StatesService.class);

    @Autowired
    private StatesRepository repository;
    private States savedStates;

    //Regras de negócio
    public StatesDto addNewStates(StatesDto states){
        log.info("addNewStates() - INICIO - Salvando o Estado {}", states.getName());

        States savedStates = repository.save(new States(states));

        log.info("addNewStates() - FIM - Estado Salvo {}", savedStates.getId());

        return new StatesDto(savedStates);

    }

    public StatesDto updateStates(StatesDto states) {
        States savedStates = repository.save(new States(states));
        repository.save(new States(states));
        return new StatesDto(savedStates);
    }

    public StatesDto getStatesById(long id){

        Optional<States> byId = repository.findById(id);
        return new StatesDto(byId.get());
    }

    public List<StatesDto> getAllStates() {
        return repository.findAll().stream().map(StatesDto::new).collect(Collectors.toList());
    }

}