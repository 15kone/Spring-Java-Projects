package com.kone.rest.webservices.restfulwebservices.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "user_details")
public class User {
  
  @JsonProperty("user_id")
  @Id
  @GeneratedValue
  private Integer id;
  @Size(min = 2, message = "Name should be longer than 2 characters.")
  @JsonProperty("username")
  private String name;
  @Past(message = "Birth date must be in the past.")
  @JsonProperty("date_of_birth")
  private LocalDate birthDate;
  
  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private List<Post> posts;
  
  public User(Integer id, String name, LocalDate birthDate) {
    
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }
  
  public User() {
  
  }
  
  
  @Override
  public String toString() {
    
    return "User{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", birthDate=" + birthDate +
           '}';
  }
  
  @Override
  public boolean equals(Object o) {
    
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(birthDate, user.birthDate);
  }
  
  @Override
  public int hashCode() {
    
    return Objects.hash(id, name, birthDate);
  }
  
  public Integer getId() {
    
    return id;
  }
  
  public void setId(Integer id) {
    
    this.id = id;
  }
  
  public String getName() {
    
    return name;
  }
  
  public void setName(String name) {
    
    this.name = name;
  }
  
  public LocalDate getBirthDate() {
    
    return birthDate;
  }
  
  public void setBirthDate(LocalDate birthDate) {
    
    this.birthDate = birthDate;
  }
  
  public List<Post> getPosts() {
    
    return posts;
  }
  
  public void setPosts(List<Post> posts) {
    
    this.posts = posts;
  }
  
}
