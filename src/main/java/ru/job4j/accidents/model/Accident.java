package ru.job4j.accidents.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "accidents")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Accident {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private String text;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", foreignKey = @ForeignKey(name = "TYPE_ID_FK"))
    private AccidentType type;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rules_accidents", joinColumns = {
            @JoinColumn(name = "accident_id")},
            inverseJoinColumns = {
            @JoinColumn(name = "rule_id")
    })
    private Set<Rule> rules = new HashSet<>();

}
