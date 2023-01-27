package com.kone.ToDoApp.todo;

/*
  H2 Database to store todos
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Todo {
  
  @Id
  @GeneratedValue
  private int id;
  private String username;
  
  @Size(min = 10, max = 50, message = "Enter between 10 and 50 characters, " +
                                      "please.")
  private String description;
  private LocalDate targetDate;
  private boolean isDone;
  
  public Todo(int id, String username, String description, LocalDate targetDate, boolean isDone) {
    
    this.id = id;
    this.username = username;
    this.description = description;
    this.targetDate = targetDate;
    this.isDone = isDone;
  }
  
  public Todo() {
  
  }
  
  @Override
  public String toString() {
    
    return "Todo{" +
           "id=" + id +
           ", username='" + username + '\'' +
           ", description='" + description + '\'' +
           ", targetDate=" + targetDate +
           ", isDone=" + isDone +
           '}';
  }
  
  @Override
  public boolean equals(Object o) {
    
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Todo todo = (Todo) o;
    return id == todo.id && isDone == todo.isDone && Objects.equals(username, todo.username) && Objects.equals(description, todo.description) && Objects.equals(targetDate, todo.targetDate);
  }
  
  @Override
  public int hashCode() {
    
    return Objects.hash(id, username, description, targetDate, isDone);
  }
  
  public int getId() {
    
    return id;
  }
  
  public void setId(int id) {
    
    this.id = id;
  }
  
  public String getUsername() {
    
    return username;
  }
  
  public void setUsername(String username) {
    
    this.username = username;
  }
  
  public String getDescription() {
    
    return description;
  }
  
  public void setDescription(String description) {
    
    this.description = description;
  }
  
  public LocalDate getTargetDate() {
    
    return targetDate;
  }
  
  public void setTargetDate(LocalDate targetDate) {
    
    this.targetDate = targetDate;
  }
  
  public boolean isDone() {
    
    return isDone;
  }
  
  public void setDone(boolean done) {
    
    isDone = done;
  }
  
}
