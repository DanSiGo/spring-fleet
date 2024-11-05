package com.example.fleet.domain.repository;

import com.example.fleet.domain.to.PageTO;
import com.example.fleet.domain.to.PaginationTO;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepository<T> {
    T save(T entity);
    PageTO<T> findAll(PaginationTO paginationTO);
    Optional<T> findById(UUID id);
    Optional<T> findByName(String name);
    Optional<T> delete(UUID id);
}
