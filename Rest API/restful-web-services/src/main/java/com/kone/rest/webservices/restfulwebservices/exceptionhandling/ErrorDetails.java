package com.kone.rest.webservices.restfulwebservices.exceptionhandling;

import java.time.LocalDateTime;
import java.util.Objects;

public class ErrorDetails {
  //error timestamp
  //error message
  //error details
  
  
  private LocalDateTime timestamp;
  private String message;
  private String details;
  
  
  public ErrorDetails(LocalDateTime timestamp, String message, String details) {
    
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
  }
  
  public ErrorDetails() {
  
  }
  
  @Override
  public String toString() {
    
    return "ErrorDetails{" +
           "timestamp=" + timestamp +
           ", message='" + message + '\'' +
           ", details='" + details + '\'' +
           '}';
  }
  
  @Override
  public boolean equals(Object o) {
    
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ErrorDetails that = (ErrorDetails) o;
    return Objects.equals(timestamp, that.timestamp) && Objects.equals(message, that.message) && Objects.equals(details, that.details);
  }
  
  @Override
  public int hashCode() {
    
    return Objects.hash(timestamp, message, details);
  }
  
  public LocalDateTime getTimestamp() {
    
    return timestamp;
  }
  
  public String getMessage() {
    
    return message;
  }
  
  
  public String getDetails() {
    
    return details;
  }
  
  
}
