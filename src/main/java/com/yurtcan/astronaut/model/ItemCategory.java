package com.yurtcan.astronaut.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "item_category")
public class ItemCategory {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
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

  @OneToMany(mappedBy = "itemCategory", cascade = CascadeType.ALL)
  private List<Item> items;

}


