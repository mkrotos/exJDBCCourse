package com.krotos.database.jdbc;

import com.krotos.models.Run;

import java.util.List;
import java.util.Optional;

public interface RunDAO {
    void save(Run run);
    Optional<Run> findById(long id);
    void update(Run run);
    void delete(long id);
    List<Run> getAll();
}
