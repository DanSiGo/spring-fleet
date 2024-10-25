package com.example.fleet.domain.repository;

public interface BaseRepository<T> {
    T save(T entity);
}
