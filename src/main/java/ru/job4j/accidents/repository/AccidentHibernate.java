package ru.job4j.accidents.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class AccidentHibernate {

    private final SessionFactory sf;

    public Accident save(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
            return accident;
        }
    }

    public List<Accident> getAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident", Accident.class)
                    .list();
        }
    }

    public Accident getById(int id) {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident where id = :fId", Accident.class)
                    .setParameter("fId", id).getSingleResult();
        }
    }

    public void update(Accident accident) {
        try (Session session = sf.openSession()) {
            session.update(accident);
        }
    }

    public void addType(AccidentType accidentType) {
        try (Session session = sf.openSession()) {
            session.save(accidentType);
        }
    }

    public List<AccidentType> getAllTypes() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from AccidentType", AccidentType.class).getResultList();
        }
    }

    public AccidentType getTypeById(int id) {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from AccidentType where id = :fId", AccidentType.class)
                    .setParameter("fId", id).getSingleResult();
        }
    }

    public void addRule(Rule rule) {
        try (Session session = sf.openSession()) {
            session.save(rule);
        }
    }

    public List<Rule> getAllRules() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Rule", Rule.class).getResultList();
        }
    }
}
