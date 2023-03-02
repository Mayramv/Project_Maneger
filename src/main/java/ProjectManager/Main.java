/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManager;
import controller.ProjectController;
import controller.TaskController;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;
/**
 *
 * @author Mayra
 */
public class Main {

    
    public static void main(String[] args) throws SQLException {

      //ProjectController projectController = new ProjectController();
        
      //Project project = new Project();
      //project.setName("projeto Teste");
     // project.setDescription("description");
     //projectController.save(project);
      
      ProjectController projectController = new ProjectController();
      Project project = new Project();
      project.setId(1);
      project.setName("novo nome do projeto de novo");
      project.setDescription("description");
     projectController.updade(project);
      
     /// List<Project> projects = projectController.getAll();
       // System.out.println("Total de projetos e: " + projects.size());
       
        //projectController.removeBy(2);
        
        //TaskController taskController = new  TaskController();
        //Task task = new Task();
        //task.setIdProject(1);
        //task.setName("minha novo tarefa 2");
        //task.setDescription(" novo descriçao");
       //task.setNotes("testando");
       //task.setIsCompleted(true);
       //task.setDeadline(new Date());
        
       // taskController.save(task);
        
     TaskController taskController = new  TaskController();
      Task task = new Task();
      task.setId(1);
     task.setIdProject(1);
      task.setName("testando");
     task.setDescription("description");
      taskController.updade(task);        
      
      List<Task> tasks = taskController.getAll(1);
       System.out.println("Total de tarefas e: " + tasks.size());
       
       taskController.removeBy(2);
     
        
      
        
        
        
      
    }
    
}
