package com.krotos.database.jdbc;

import com.krotos.models.Member;

import java.util.List;
import java.util.Optional;

public interface MemberDAO {
    void save(Member member);
    Optional<Member> findById(long id);
    void update(Member member);
    void delete(long id);
    List<Member> getAll();
}
