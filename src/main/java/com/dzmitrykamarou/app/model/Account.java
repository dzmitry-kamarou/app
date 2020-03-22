package com.dzmitrykamarou.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {

  @Id
  @GeneratedValue(generator = "account_generator")
  @SequenceGenerator(
      name = "account_generator",
      sequenceName = "account_sequence"
  )
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
