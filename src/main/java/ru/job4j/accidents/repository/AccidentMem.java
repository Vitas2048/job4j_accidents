package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private ConcurrentMap<Integer, Accident> accidents = new ConcurrentHashMap<>();

    private List<AccidentType> types = new CopyOnWriteArrayList<>();

    private AtomicInteger num = new AtomicInteger(0);

    public void insert(Accident accident) {
        accident.setId(num.incrementAndGet());
        accidents.put(accident.getId(), accident);
    }

    public List<Accident> findAll() {
        return new ArrayList<Accident>(accidents.values());
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }

    public void update(Accident accident) {
        accidents.replace(accident.getId(), accident);
    }

    public void addType(AccidentType accidentType) {
        types.add(accidentType);
    }

    public List<AccidentType> getAllTypes() {
        return new ArrayList<>(types);
    }

    public AccidentType getTypeById(int id) {
        return types.get(id);
    }
}
