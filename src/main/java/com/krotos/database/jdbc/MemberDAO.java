package com.krotos.database.jdbc;

import com.krotos.models.Member;

import java.util.List;

public interface MemberDAO {
    void save(Member member);
    void delete(long id);
    List<Member> getAll();
}
