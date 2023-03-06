/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Mayra
 */
public class TaskController {

    public void save(Task task) {
        String sql = "INSERT INTO tasks (idprojects,"
                + "Name,"
                + "Description,"
                + "Completed,"
                + "Notes,"
                + "Deadline,"
                + "CreatedAt,"
                + "UpdatedAt) VALUE (?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void updade(Task task) {

        String sql = " UPDATE tasks SET idprojects = ?, "
                + "Name = ?, "
                + "Description = ?, "
                + "Completed = ?, "
                + "Notes = ?, "
                + "Deadline = ?, "
                + "CreatedAt = ?, "
                + "UpdatedAt = ? "
                + "WHERE id = ? ";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //estabeleendo a conexao com o banco de dados.
            connection = ConnectionFactory.getConnection();
            
            //preprarando a query
            statement = connection.prepareStatement(sql);
            
            //setando os valores no statement.
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            
            //executando o query
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar a tarefa"
                    + ex.getMessage(), ex);
        }finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeBy(int taskId){
        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Task> getAll(int idProjects) {
        String sql = "SELECT * FROM  tasks WHERE idProjects = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        ResultSet resultSet = null;
        
        List<Task> tasks = new ArrayList<Task> ();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //setando o vallor que corresponde ao filtro de buscar
            statement.setInt(1, idProjects);
            
            // valor retornado da Query
            resultSet = statement.executeQuery();
            
            
            // enquanto houverem valores a serem percorrido
            while(resultSet.next()) {
                 
                Task task = new Task ();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProjects"));
                task.setName(resultSet.getString("Name"));
                task.setDescription(resultSet.getString("Description"));
                task.setNotes(resultSet.getString("Notes"));
                task.setIsCompleted(resultSet.getBoolean("Completed"));
                task.setDeadline(resultSet.getDate("Deadline"));
                task.setCreatedAt(resultSet.getDate("CreatedAt"));
                task.setUpdatedAt(resultSet.getDate("UpdatedAt"));
                
                tasks.add(task);
                
                 }
            
        } catch (SQLException ex) {
        throw new RuntimeException("Erro ao listar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return tasks;
    }

}
