package com.krotos.database.jdbc.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDriverDAO {

    private Connection connection;

    public JdbcDriverDAO(){
        connection=JdbcUtils.getInstance().getConnection();
    }

    public void save(long id,String name, String lastName,int startNumber,long runId){
        try {
            PreparedStatement statement=connection.prepareStatement("INSERT into members values (?,?,?,?,?)");
            statement.setLong(1,id);
            statement.setString(2,name);
            statement.setString(3,lastName);
            statement.setInt(4,startNumber);
            statement.setLong(5,runId);
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
        List<Member> memberList=new ArrayList<Member>();
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
