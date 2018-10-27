package com.krotos;

import com.krotos.database.GenerateRandom;
import com.krotos.database.jdbc.MemberJdbcDriverDAO;
import com.krotos.database.jdbc.RunJdbcDriverDAO;
import com.krotos.models.Member;
import com.krotos.models.Run;

import java.util.List;

public class Main {

    public static void main(String[] args){

        GenerateRandom generateRandom=new GenerateRandom();
        generateRandom.members(5);
        generateRandom.runs(3);

        MemberJdbcDriverDAO memberJdbcDriverDAO =new MemberJdbcDriverDAO();
//        Member member = new Member(5, "234", "ewer", 5, 1);
//        memberJdbcDriverDAO.save(member);
//        memberJdbcDriverDAO.delete(2);

        List<Member> memberList = memberJdbcDriverDAO.getAll();
        System.out.println(memberList);

        RunJdbcDriverDAO runJdbcDriverDAO=new RunJdbcDriverDAO();
//        Run run=new Run(2,"run","somewhere",LocalDate.now(),LocalTime.now(),10);
//        runJdbcDriverDAO.save(run);
        List<Run> runList = runJdbcDriverDAO.getAll();
        System.out.println(runList);
    }
}
