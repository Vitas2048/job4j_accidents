CREATE TABLE rules_accidents (
  accident_id int references accidents(id),
  rule_id int references rules(id)
);
