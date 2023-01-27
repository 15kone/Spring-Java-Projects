package com.kone.ToDoApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {
  
  @Bean
  public InMemoryUserDetailsManager createUserDetailsManager() {
    
    UserDetails userDetailsDefault = createNewUser("user", "pass");
    
    return new InMemoryUserDetailsManager(userDetailsDefault);
  }
  
  private UserDetails createNewUser(String username, String password) {
    
    Function<String, String> passwordEncoder =
      input -> passwordEncoder().encode(input);
    
    UserDetails userDetails =
      User.builder().passwordEncoder(passwordEncoder).username(username)
        .password(password).roles("USER", "ADMIN").build();
    
    return userDetails;
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    
    return new BCryptPasswordEncoder();
  }
  
  /*
  All urls are protected
  A login form is shown for unatuhorized requests
  CSRF disable
   */
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //    ensure that all requests are authenticated
    //    if unauthenticated, show login form
    http.authorizeHttpRequests(
      auth -> auth.anyRequest().authenticated());
    http.formLogin(withDefaults());
    
    http.csrf().disable();
    http.headers().frameOptions().disable();
    
    return http.build();
  }
  
}
