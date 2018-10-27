package com.krotos.database;

import com.krotos.database.jdbc.MemberDAO;
import com.krotos.database.jdbc.MemberJdbcDriverDAO;
import com.krotos.database.jdbc.RunDAO;
import com.krotos.database.jdbc.RunJdbcDriverDAO;

public class DaoProvider {
    private static final DaoProvider instance=new DaoProvider();

    private RunDAO runDAO;
    private MemberDAO memberDAO;

    public DaoProvider() {
        runDAO=new RunJdbcDriverDAO();
        memberDAO=new MemberJdbcDriverDAO();
    }

    public static DaoProvider getInstance() {
        return instance;
    }

    public RunDAO getRunDAO() {
        return runDAO;
    }

    public MemberDAO getMemberDAO() {
        return memberDAO;
    }
}
