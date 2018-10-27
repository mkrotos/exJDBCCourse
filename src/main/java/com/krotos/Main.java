package com.krotos;

import com.krotos.database.GenerateRandom;
import com.krotos.database.jdbc.MemberDAO;
import com.krotos.database.jdbc.MemberJdbcDriverDAO;
import com.krotos.database.jdbc.RunDAO;
import com.krotos.database.jdbc.RunJdbcDriverDAO;
import com.krotos.models.Member;
import com.krotos.models.Run;

import java.util.List;

public class Main {

    public static void main(String[] args){

        GenerateRandom generateRandom=new GenerateRandom();
        generateRandom.members(0);
        generateRandom.runs(0);

        MemberDAO memberDAO =new MemberJdbcDriverDAO();
//        Member member = new Member(5, "234", "ewer", 5, 1);
//        memberDAO.save(member);
//        memberDAO.delete(2);

        List<Member> memberList = memberDAO.getAll();
        System.out.println(memberList);

        RunDAO runDAO=new RunJdbcDriverDAO();
//        Run run=new Run(2,"run","somewhere",LocalDate.now(),LocalTime.now(),10);
//        runDAO.save(run);
        List<Run> runList = runDAO.getAll();
        System.out.println(runList);
    }
}
