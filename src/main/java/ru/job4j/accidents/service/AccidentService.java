package ru.job4j.accidents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;
import ru.job4j.accidents.repository.AccidentRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccidentService {

    private final AccidentRepository accidentsRepository;

    public void save(Accident accident) {
        accidentsRepository.save(accident);
    }

    public List<Accident> findAll() {
        return accidentsRepository.findAll();
    }

    public Optional<Accident> getById(int id) {
        return accidentsRepository.findById(id);
    }

}
