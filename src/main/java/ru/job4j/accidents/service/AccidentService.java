package ru.job4j.accidents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;
import ru.job4j.accidents.repository.AccidentHibernate;
import ru.job4j.accidents.repository.AccidentJdbcTemplate;
import ru.job4j.accidents.repository.AccidentMem;

import java.util.List;

@Service
@AllArgsConstructor
public class AccidentService {

    private final AccidentHibernate accidentsRepository;

    public void create(Accident accident) {
        accidentsRepository.save(accident);
    }

    public void add(Accident accident) {
        accidentsRepository.save(accident);
    }

    public List<Accident> findAll() {
        return accidentsRepository.getAll();
    }

    public Accident getById(int id) {
        return accidentsRepository.getById(id);
    }

    public void update(Accident accident) {
        accidentsRepository.update(accident);
    }

    public void addType(AccidentType accidentType) {
        accidentsRepository.addType(accidentType);
    }

    public List<AccidentType> getAllTypes() {
        return accidentsRepository.getAllTypes();
    }

    public AccidentType getTypeById(int id) {
        return accidentsRepository.getTypeById(id);
    }

    public void addRule(Rule rule) {
        accidentsRepository.addRule(rule);
    }

    public List<Rule> getAllRules() {
        return accidentsRepository.getAllRules();
    }
}
