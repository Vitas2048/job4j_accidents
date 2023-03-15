package ru.job4j.accidents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.repository.AccidentMem;

import java.util.List;

@Service
@AllArgsConstructor
public class AccidentService {

    private final AccidentMem accidentMem;

    public void add(Accident accident) {
        accidentMem.insert(accident);
    }

    public List<Accident> findAll() {
        return accidentMem.findAll();
    }

    public Accident getById(int id) {
        return accidentMem.findById(id);
    }

    public void update(Accident accident) {
        accidentMem.update(accident);
    }

    public void addType(AccidentType type) {
        accidentMem.addType(type);
    }

    public List<AccidentType> getAllTypes() {
        return accidentMem.getAllTypes();
    }

    public AccidentType findById(int id) {
        return accidentMem.getTypeById(id);
    }
}
