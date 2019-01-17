package com.yurtcan.astronaut.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "user_name", nullable = false, unique = true, length = 256)
  private String userName;

  @Column(name = "password", length = 256)
  private String password;

  @Column(name = "first_name", length = 256)
  private String firstName;

  @Column(name = "last_name", length = 256)
  private String lastName;

  @Column(name = "email", length = 256)
  private String email;

  @Column(name = "enabled")
  private Integer enabled;

  @Column(name = "creation_date", length = 256)
  private Date creationDate;

  @Column(name = "modification_date", length = 256)
  private Date modificationDate;

  @Column(name = "created_by", length = 256)
  private Long createdBy;

  @Column(name = "modified_by", length = 256)
  private Long modifiedBy;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
          name = "user_roles",
          joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Set<Role> roles;

}


