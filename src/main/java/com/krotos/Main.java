package com.krotos;

import com.krotos.database.DaoProvider;
import com.krotos.database.GenerateRandom;
import com.krotos.database.jdbc.MemberDAO;
import com.krotos.database.jdbc.RunDAO;
import com.krotos.models.Member;
import com.krotos.models.Run;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        GenerateRandom generateRandom = new GenerateRandom();
        generateRandom.members(0);
        generateRandom.runs(0);

        MemberDAO memberDAO = DaoProvider.getInstance().getMemberDAO();
        Member member = new Member(121, "234", "ewer", 5, 1);
        memberDAO.save(member);
        member.setName("Updated");
        memberDAO.update(member);
//        memberDAO.delete(2);

        List<Member> memberList = memberDAO.getAll();
        System.out.println(memberList);
        System.out.println("Find: " + memberDAO.findById(3));

        RunDAO runDAO = DaoProvider.getInstance().getRunDAO();
//        Run run=new Run(2,"run","somewhere",LocalDate.now(),LocalTime.now(),10);
//        runDAO.save(run);
        List<Run> runList = runDAO.getAll();
        System.out.println(runList);
    }
}
