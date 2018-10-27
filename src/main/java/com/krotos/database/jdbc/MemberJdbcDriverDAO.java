package com.krotos.database.jdbc;

import com.krotos.database.jdbc.utils.JdbcUtils;
import com.krotos.models.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberJdbcDriverDAO implements MemberDAO {

    private Connection connection;

    public MemberJdbcDriverDAO(){
        connection=JdbcUtils.getInstance().getConnection();
    }

    public void save(Member member){
        try {
            PreparedStatement statement=connection.prepareStatement("INSERT into members values (?,?,?,?,?)");
            statement.setLong(1,member.getId());
            statement.setString(2,member.getName());
            statement.setString(3,member.getLastName());
            statement.setInt(4,member.getStartNumber());
            statement.setLong(5,member.getRunId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(long id){
        try {
            PreparedStatement statement=connection.prepareStatement("delete from members where ID=?");
            statement.setLong(1,id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Member> getAll(){
        List<Member> memberList=new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from members");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                memberList.add(new Member(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("start_number"),
                        resultSet.getLong("run_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }
}
