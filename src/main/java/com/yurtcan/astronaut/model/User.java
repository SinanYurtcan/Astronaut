package com.yurtcan.astronaut.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.yurtcan.astronaut.model.helper.EntityListener;
import com.yurtcan.astronaut.model.helper.EntityStatus;
import com.yurtcan.astronaut.model.helper.Persistable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EntityListeners(EntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User implements Persistable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "creation_date", length = 256)
  @CreationTimestamp
  private Date creationDate;

  @Column(name = "modification_date", length = 256)
  @UpdateTimestamp
  private Date modificationDate;

  @Column(name = "created_by", length = 256)
  private Long createdBy;

  @Column(name = "modified_by", length = 256)
  private Long modifiedBy;

  @Column(name = "status", length = 1)
  @Enumerated(EnumType.STRING)
  private EntityStatus status;

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

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
          name = "user_roles",
          joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Set<Role> roles;

}


