package ru.job4j.accidents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.repository.AccidentTypeRepository;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccidentTypeService {

    AccidentTypeRepository accidentTypeRepository;

    public void addType(AccidentType accidentType) {
        accidentTypeRepository.save(accidentType);
    }

    public List<AccidentType> getAllTypes() {
        return accidentTypeRepository.findAll();
    }

    public Optional<AccidentType> getTypeById(int id) {
        return accidentTypeRepository.findById(id);
    }


}
