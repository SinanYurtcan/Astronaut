package com.yurtcan.astronaut.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "household")
public class Household implements Persistable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "creation_date", length = 256)
  private Date creationDate;

  @Column(name = "modification_date", length = 256)
  private Date modificationDate;

  @Column(name = "created_by", length = 256)
  private Long createdBy;

  @Column(name = "modified_by", length = 256)
  private Long modifiedBy;

  @Column(name = "status", length = 1)
  @Enumerated(EnumType.STRING)
  private EntityStatus status;

  @Column(name = "name", nullable = false, unique = true, length = 256)
  private String name;

}


