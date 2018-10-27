package com.krotos.database;

import com.krotos.database.jdbc.MemberJdbcDriverDAO;
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
        MemberJdbcDriverDAO memberJdbcDriverDAO=new MemberJdbcDriverDAO();
        for (int i=0;i<amount;i++){
            Member member=new Member(random.nextInt(),
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    random.nextInt(),
                    random.nextInt());
            memberJdbcDriverDAO.save(member);
        }
    }

    public void runs(int amount){
        RunJdbcDriverDAO runJdbcDriverDAO=new RunJdbcDriverDAO();
        for (int i=0;i<amount;i++){
            Run run=new Run(random.nextInt(),
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    LocalDate.now(),
                    LocalTime.now(),
                    random.nextInt());
            runJdbcDriverDAO.save(run);
        }
    }
}
