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
import model.Project;

import util.ConnectionFactory;

/**
 *
 * @author Mayra
 */
public class ProjectController{
      public void save(Project project) {
        String sql = "INSERT INTO projects (Name"
                + "Description,"
                + "CreatedAt,"
                + "UpdatedAt) VALUE (?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar projeto"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void updade(Project project) {

        String sql = " UPDATE projects SET"
                + "Name = ?, "
                + "Description = ?, "
                + "CreatedAt = ? "
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
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            
            //executando o query
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar projeto"
                    + ex.getMessage(), ex);
        }finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

     public List<Project> getAll() {
        String sql = "SELECT * FROM  projects";
        
        List<Project> projects = new ArrayList<> ();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        ResultSet resultSet = null;
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
             // valor retornado da Query
            resultSet = statement.executeQuery();
            
            
            // enquanto houverem valores a serem percorrido
            while(resultSet.next()) {
                 
               Project project = new Project ();
               
               project.setId(resultSet.getInt("id"));
               project.setName(resultSet.getString("Name"));
               project.setDescription(resultSet.getString("Description"));
               project.setCreatedAt(resultSet.getDate("CreatedAt"));
               project.setUpdatedAt(resultSet.getDate("UpdatedA"));
                
                projects.add(project);
                
                 }
            
        } catch (SQLException ex) {
        throw new RuntimeException("Erro ao salvar a projeto"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return projects;
    }

    public void removeBy(int idProject) throws SQLException {
        String sql = "DELETE FROM project WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,idProject);
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
