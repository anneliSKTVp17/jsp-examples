/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class User {
    private String name;
    private String password;
    private LocalDate birthDate;

    public User(String name, String password, LocalDate birthDate) {
    this.name = name;
this.password = password;
this.birthDate = birthDate;
    }
  public String getName() {
      return name;
  }  
  public void setName(String name) {
      this.name = name;
  }
  public String getPassword() {
      return password;
  }
  public void setPassword(String password) {
      this.password = password;
  }
  public LocalDate getBirthDate() {
      return birthDate;
  }
  public void setBirthDate(LocalDate birthDate) {
      this.birthDate = birthDate;
  }
}
