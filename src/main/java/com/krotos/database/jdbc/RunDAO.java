package com.krotos.database.jdbc;

import com.krotos.models.Run;

import java.util.List;

public interface RunDAO {
    void save(Run run);
    void delete(long id);
    List<Run> getAll();
}
