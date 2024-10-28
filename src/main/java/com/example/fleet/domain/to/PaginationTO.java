package com.example.fleet.domain.to;

import java.util.Map;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationTO {

  private int page;
  private int size;

  public PaginationTO(int page, int size) {
    this.page = page;
    this.size = size;
  }

  private Map<String, Object> params;

}
