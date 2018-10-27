package com.krotos.database.jdbc;

import com.krotos.database.jdbc.utils.JdbcUtils;
import com.krotos.models.Run;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RunJdbcDriverDAO implements RunDAO {

    public void save(Run run){
        Connection connection=JdbcUtils.getInstance().getConnection();
        try {
            PreparedStatement statement=connection.prepareStatement("insert into runs values (?,?,?,?,?,?)");
            statement.setLong(1,run.getId());
            statement.setString(2,run.getName());
            statement.setString(3,run.getPlace());
            statement.setDate(4,Date.valueOf(run.getStartDate()));
            statement.setInt(5, run.getMembersLimit());
            statement.setTime(6,Time.valueOf(run.getStartTime()));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Run> findById(long id) {
        Connection connection=JdbcUtils.getInstance().getConnection();

        Run run=null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from runs where ID=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                run=new Run(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("place"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getTime("start_date").toLocalTime(),
                        resultSet.getInt("members_limit")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(run);
    }

    @Override
    public void update(Run run) {
        Connection connection=JdbcUtils.getInstance().getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("update runs " +
                    "set NAME=?,PLACE=?,START_DATE=?,MEMBERS_LIMIT=?, START_DATE=? " +
                    "where ID=?");
            statement.setString(1,run.getName());
            statement.setString(2,run.getPlace());
            statement.setDate(3,Date.valueOf(run.getStartDate()));
            statement.setInt(4, run.getMembersLimit());
            statement.setTime(5,Time.valueOf(run.getStartTime()));
            statement.setLong(6,run.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id){
        Connection connection=JdbcUtils.getInstance().getConnection();
        try {
            PreparedStatement statement=connection.prepareStatement("delete from runs where ID=?");
            statement.setLong(1,id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Run> getAll(){
        Connection connection=JdbcUtils.getInstance().getConnection();
        List<Run> runs=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("select * from runs");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                runs.add(new Run(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("place"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getTime("start_date").toLocalTime(),
                        resultSet.getInt("members_limit")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return runs;
    }
}
