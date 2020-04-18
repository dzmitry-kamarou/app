package com.dzmitrykamarou.diamond.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
@JsonPropertyOrder({"id", "firstName", "lastName", "createdAt", "updatedAt"})
public class Account extends BaseEntity {

  @Id
  @GeneratedValue(generator = "account_generator")
  @SequenceGenerator(
      name = "account_generator",
      sequenceName = "account_sequence"
  )
  private Long id;
  private String firstName;
  private String lastName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
