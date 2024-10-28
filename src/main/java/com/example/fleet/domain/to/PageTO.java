package com.example.fleet.domain.to;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageTO<T> {

  private List<T> content;

  private long total;

  private int page;

  private int size;

  public PageTO(List<T> content, long total){
    this.content = content;
    this.total = total;
  }

  public PageTO(List<T> content, long total, int page, int size) {
    this.content = content;
    this.total = total;
    this.page = page;
    this.size = size;
  }

  public static <T> PageTO<T> of(PageTO<?> other, List<T> newContent) {
    return new PageTO<>(newContent, other.total, other.page, other.size);
  }
}
