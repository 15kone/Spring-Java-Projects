package com.kone.ToDoApp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
  
  private static final List<Todo> todos = new ArrayList<>();
  
  private static int todosCount = 0;
  
  static {
    
    todos.add(
      new Todo(++todosCount, "user", "Learn Spring",
        LocalDate.now().plusYears(1), false)
    );
  }
  
  public Todo findById(int id) {
    
    Predicate<? super Todo> predicate = todo -> todo.getId() == id;
    
    Todo todo = todos.stream().filter(predicate).findFirst().get();
    
    return todo;
  }
  
  public List<Todo> findByUsername(String username) {
    
    Predicate<? super Todo> predicate =
      todo -> todo.getUsername().equalsIgnoreCase(username);
    
    return todos.stream().filter(predicate).toList();
  }
  
  public void addTodo(String username, String description,
                      LocalDate targetDate, boolean isDone) {
    
    Todo todo = new Todo(++todosCount, username, description, targetDate,
      isDone);
    todos.add(todo);
  }
  
  public void deleteById(int id) {
    
    Predicate<? super Todo> predicate = todo -> todo.getId() == id;
    
    todos.removeIf(predicate);
  }
  
  public void updateTodo(@Valid Todo todo) {
    
    deleteById(todo.getId());
    todos.add(todo);
  }
  
}
