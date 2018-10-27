package com.krotos.database;

import com.krotos.database.jdbc.MemberDAO;
import com.krotos.database.jdbc.MemberJdbcDriverDAO;
import com.krotos.database.jdbc.RunDAO;
import com.krotos.database.jdbc.RunJdbcDriverDAO;
import com.krotos.models.Member;
import com.krotos.models.Run;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.UUID;

public class GenerateRandom {
    private Random random=new Random();

    public void members(int amount){
        MemberDAO memberDAO=new MemberJdbcDriverDAO();
        for (int i=0;i<amount;i++){
            Member member=new Member(random.nextInt(Integer.MAX_VALUE),
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    random.nextInt(Integer.MAX_VALUE),
                    random.nextInt(Integer.MAX_VALUE));
            memberDAO.save(member);
        }
    }

    public void runs(int amount){
        RunDAO runDAO=new RunJdbcDriverDAO();
        for (int i=0;i<amount;i++){
            Run run=new Run(random.nextInt(Integer.MAX_VALUE),
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    LocalDate.now(),
                    LocalTime.now(),
                    random.nextInt(100));
            runDAO.save(run);
        }
    }
}
