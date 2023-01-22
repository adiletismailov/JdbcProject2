package org.example.dao;

import org.example.config.Util;
import org.example.model.Employee;
import org.example.model.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDaoImpl implements JobDao{
    private final Connection connection = Util.getConnection();
    @Override
    public void createJobTable() {
        String sql = "CREATE TABLE job" +
                "(id SERIAL PRIMARY KEY," +
                "position VARCHAR," +
                "profession VARCHAR," +
                "description VARCHAR," +
                "experience INT)";
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Create table job: successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addJob(Job job) {
        String sql = "INSERT INTO job(position, profession, description, experience)" +
                "VALUES (?, ?, ?, ?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, job.getPosition());
            preparedStatement.setString(2, job.getProfession());
            preparedStatement.setString(3, job.getDescription());
            preparedStatement.setInt(4, job.getExperience());
            preparedStatement.executeUpdate();
            System.out.println("Insert into job: successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Job getJobById(Long jobId) {
        Job job = new Job();
        String sql = "SELECT * FROM job WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,jobId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                job.setId(resultSet.getLong("id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return job;
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        List<Job> jobs = new ArrayList<>();
        switch (ascOrDesc) {
            case "asc":
            String sqlAsc = "SELECT * FROM job ORDER BY experience;";
                try(PreparedStatement preparedStatement = connection.prepareStatement(sqlAsc)){
                    preparedStatement.executeQuery();
                    ResultSet resultSet = preparedStatement.getResultSet();
                    while (resultSet.next()){
                        Job job = new Job();
                        job.setId(resultSet.getLong("id"));
                        job.setPosition(resultSet.getString("position"));
                        job.setProfession(resultSet.getString("profession"));
                        job.setDescription(resultSet.getString("description"));
                        job.setExperience(resultSet.getInt("experience"));
                        jobs.add(job);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "desc":
                String sqlDesc = "SELECT * FROM job ORDER BY experience DESC;";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(sqlDesc);
                    preparedStatement.executeQuery();
                    ResultSet resultSet = preparedStatement.getResultSet();
                    while (resultSet.next()){
                        Job job = new Job();
                        job.setId(resultSet.getLong("id"));
                        job.setPosition(resultSet.getString("position"));
                        job.setProfession(resultSet.getString("profession"));
                        job.setDescription(resultSet.getString("description"));
                        job.setExperience(resultSet.getInt("experience"));
                        jobs.add(job);
                    }
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return jobs;
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        Job job = new Job();
        String sqlJoin = "SELECT * FROM job JOIN employee on job.id = employee.id WHERE employee.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlJoin)){
            preparedStatement.setLong(1,employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                job.setId(resultSet.getLong("id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return job;
    }

    @Override
    public void deleteDescriptionColumn() {
        String sql = "ALTER TABLE job DROP COLUMN description;";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            System.out.println("Delete description: successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
