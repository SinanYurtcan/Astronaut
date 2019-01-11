package com.yurtcan.astronaut.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "user_name", length = 256)
  private String userName;

  @Column(name = "password", length = 256)
  private String password;

  @Column(name = "first_name", length = 256)
  private String firstName;

  @Column(name = "last_name", length = 256)
  private String lastName;

  @Column(name = "email", length = 256)
  private String email;

//  @Column(name = "enabled")
//  private boolean enabled;
//  private Date creationDate;
//  private Date modificationDate;
//  private Long createdBy;
//  private Long modifiedBy;


}


