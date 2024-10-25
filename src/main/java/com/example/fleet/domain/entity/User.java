package com.example.fleet.domain.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)

public class User extends BaseEntity {

  private String name;
  @Enumerated(EnumType.STRING)
  private Role role;

}
