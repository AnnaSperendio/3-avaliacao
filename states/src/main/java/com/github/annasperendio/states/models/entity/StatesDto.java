package com.github.annasperendio.states.models.entity;

import com.github.annasperendio.states.models.entity.repository.StatesRepository;
import com.github.annasperendio.states.service.Validation;

public class StatesDto {


    private long id; //Ex: 1
    private String name; //Ex: Rio Grande do Norte

    private String region; //Ex: Nordeste
    private String population; //Ex: 3409000
    private String capital; //Ex: Natal
    private String area; //Ex: 52 797

    public StatesDto() {
    }

    public StatesDto(long id, String name, String region, String population, String capital, String area) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.population = population;
        this.capital = capital;
        this.area = area;
    }

    public StatesDto(States savedStates) {
        this.id = savedStates.getId();
        this.name = savedStates.getName();
        this.region = savedStates.getRegion();
        this.population = savedStates.getPopulation();
        this.capital = savedStates.getCapital();
        this.area = savedStates.getArea();


    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public States updateStates(Long id, StatesRepository statesRepository) {

        States states = statesRepository.getReferenceById(id);
        states.setName(this.name);
        states.setRegion(Validation.validation(this.region));
        states.setPopulation(this.population);
        states.setCapital(this.capital);
        states.setArea(this.area);
        return states;
    }

}
