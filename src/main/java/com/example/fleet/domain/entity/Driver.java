package com.example.fleet.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.Date;

import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drivers")
@EqualsAndHashCode(callSuper = true)
public class Driver extends BaseEntity{

  private String license;

  @JsonIgnore
  @Temporal(TemporalType.DATE)
  @Column(name = "deleted_at")
  private Date deletedAt;

  @JsonIgnore
  @Temporal(TemporalType.DATE)
  @Column(name = "updated_at", nullable = false)
  private Date updatedAt;

  @JsonIgnore
  @Temporal(TemporalType.DATE)
  @Column(name = "created_at", nullable = false)
  private Date createdAT;
}
