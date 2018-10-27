package com.krotos;

import com.krotos.database.jdbc.utils.JdbcDriverDAO;
import com.krotos.database.jdbc.utils.Member;

import java.util.List;

public class Main {

    public static void main(String[] args){

        JdbcDriverDAO jdbcDriverDAO=new JdbcDriverDAO();
//        jdbcDriverDAO.save(2,"two" +
//                "","Oneee",12,1);
//        jdbcDriverDAO.delete(2);
        List<Member> memberList = jdbcDriverDAO.getAll();
        System.out.println(memberList);
    }
}
