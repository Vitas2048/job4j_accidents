package ru.job4j.accidents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.repository.AccidentRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccidentService {

    private final AccidentRepository accidentsRepository;

    public void save(Accident accident) {
        accidentsRepository.save(accident);
    }

    public Set<Accident> findAll() {
        return accidentsRepository.findAll();
    }

    public Optional<Accident> getById(int id) {
        return accidentsRepository.findById(id);
    }

}
