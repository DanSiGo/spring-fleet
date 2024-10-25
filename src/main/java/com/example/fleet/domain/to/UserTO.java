package com.example.fleet.domain.to;

import com.example.fleet.domain.entity.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTO {

  private String name;
  private Role role;
}
