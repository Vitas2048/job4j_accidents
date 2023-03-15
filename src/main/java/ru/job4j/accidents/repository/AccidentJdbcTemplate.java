package ru.job4j.accidents.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;

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
}
