package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class AccidentMem {

    private ConcurrentMap<Integer, Accident> accidents = new ConcurrentHashMap<>();

    public void insert(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    public List<Accident> findAll() {
        return new ArrayList<Accident>(accidents.values());
    }

}
