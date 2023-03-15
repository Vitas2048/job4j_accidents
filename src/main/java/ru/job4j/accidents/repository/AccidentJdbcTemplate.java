package ru.job4j.accidents.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;

import java.util.List;
@Repository
@AllArgsConstructor
public class AccidentJdbcTemplate {

    private final JdbcTemplate jdbc;

    public Accident save(Accident accident) {
        jdbc.update("insert into accidents (name) values (?)",
                accident.getName());
        return accident;
    }

    public List<Accident> getAll() {
        return jdbc.query("select id, name from accidents",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }

    public Accident findById(int id) {
        return jdbc.queryForObject(
                "select name from accidents where id = ?",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setName(rs.getString("name"));
                    return accident;
                }, id
        );
    }

    public void update(Accident accident) {
        jdbc.update("update accidents set name = ? where id = ?", accident.getName(), accident.getId());
    }

    public void addType(AccidentType accidentType) {
        jdbc.update("insert into accident_types(name) values (?)", accidentType.getName());
    }

    public List<AccidentType> getAllTypes() {
        return jdbc.query("select id, name from accident_types",
                (rs, row) -> {
                    AccidentType accident = new AccidentType();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }

    public AccidentType getTypeById(int id) {
        return jdbc.queryForObject(
                "select name from accident_types where id = ?",
                (rs, row) -> {
                    AccidentType accident = new AccidentType();
                    accident.setName(rs.getString("name"));
                    return accident;
                }, id
        );
    }

    public void addRule(Rule rule) {
        jdbc.update("insert into rules(name) values (?)", rule.getName());
    }

    public List<Rule> getAllRules() {
        return jdbc.query("select id, name from rules",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
    }
}
